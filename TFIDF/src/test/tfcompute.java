package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jeasy.analysis.MMAnalyzer;

public class tfcompute {
	static String path = "trainfolder";
	//static String path = "E:\\ÑµÁ·¼¯\\SogouC.reduced\\Reduced";
	static Map<String, Map<String, Double>> DFdic = new HashMap();
	static HashMap<String, List<Map<String, Double>>> dic = new HashMap();
	static int DCOUNT;
	static HashMap<String, Double> idfDic = new HashMap();
	 static      Map<String, Map<String,Double>> TFIDFdic = new HashMap();
	// static Map<String,List<String>> Simpledic= new HashMap();
	public static void main(String[] args) throws IOException {

		tfcompute tf = new tfcompute();
		File[] Filelist = tf.readData(path);
		DCOUNT = Filelist.length;
		tf.readir(Filelist);
		tf.computeIDF(dic);
        tf.ComputeTFIDF(); 
        for( String s :TFIDFdic.keySet())
        {
         Map map  = TFIDFdic.get(s);
         for(Object key :map.keySet() )
         {
        	 System.out.println("file "+s +"word "+ key+" tfidf "+map.get(key));
        	 
         }
        	
        }
		

	}

	public void readir(File[] dir) throws IOException {

		File[] fileList = dir;

		for (int i = 0; i < fileList.length; i++) {
			File f = fileList[i];
			System.out.println(f.getPath());
			String[] textword = cutWord(FiletoText(f.getPath()));
			Map tf = computeTf(textword);
			DFdic.put(f.getPath(), tf);
			addDic(f.getPath(), tf);
		}

		System.out.println("TF PROCESS IS OVER");

		System.out.println(dic.size());
		for (Object o : dic.keySet()) {
			System.out.println(o);
			List list = dic.get(o);
			for (Object l : list) {
				Map pair = (Map) l;
				for (Object p : pair.keySet()) {
					System.out.println("key" + (String) o + "..."
							+ "filepath...." + p + "tf..." + pair.get(p));
				}

			}

		}

	}

	public String FiletoText(String path) throws IOException {
		File f = new File(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(f), "GB2312"));
		String result = "";
		String temp;
		while ((temp = br.readLine()) != null) {
			result = result + temp;
		}
		br.close();
		return result;
	}

	public String[] cutWord(String text) throws IOException {
		MMAnalyzer analyzer = new MMAnalyzer();
		String temp = analyzer.segment(text, "|");
		System.out.println(temp);
		String[] result = temp.split("\\|");
		/*
		 * for(String s :result ) { System.out.println(s); }
		 */
		return result;
	}

	public HashMap<String, Double> computeTf(String[] textword) {
		double size = textword.length;
		HashMap<String, Integer> map = new HashMap();
		for (int i = 0; i < textword.length; i++) {
			System.out.println(textword[i]);
			if (map.containsKey(textword[i])) {
				Integer count = map.get(textword[i]);

				map.put(textword[i], count + 1);

			} else {
				map.put(textword[i], 1);
			}

		}

		HashMap<String, Double> result = new HashMap();
		for (Object o : map.keySet()) {
			Integer temp = map.get(o);

			System.out.println((String) o + "count..." + temp);
			result.put((String) o, temp / size);
			System.out.println((String) o + "tf..." + result.get(o));

		}

		return result;

	}

	public void addDic(String path, Map tf) {
		System.out.println(",,,,,,,,,,,,,");
		for (Object o : tf.keySet()) {
			if (dic.containsKey((String) o)) {

				ArrayList list = (ArrayList) dic.get(o);
				HashMap map = new HashMap();
				map.put(path, (Double) tf.get((String) o));
				list.add(map);
				dic.put((String) o, list);
			} else {
				HashMap map = new HashMap();
				map.put(path, (Double) tf.get((String) o));
				ArrayList list = new ArrayList<Map<String, Double>>();
				list.add(map);
				dic.put((String) o, list);
			}

		}

	}

	public static File[] readData(String path) {
		int size = 0;
		File[] floderdir = new File(path).listFiles();
		ArrayList list = new ArrayList();
		for (File f : floderdir) {
			// size = size+(int)f.length();
			File[] childdir = f.listFiles();
			for (File file : childdir) {
				list.add(file);

			}
		}
		size = list.size();
		File[] fdir = new File[size];
		for (int i = 0; i < size; i++) {
			fdir[i] = (File) list.get(i);

		}

		return fdir;

	}

	public void computeIDF(HashMap<String, List<Map<String, Double>>> map) {

		for (String key : map.keySet()) {
			List list = map.get(key);
			double hasCount = (double) list.size();
			double idf = DCOUNT / hasCount;

			idfDic.put(key, idf);
		}

	}

	public void ComputeTFIDF() {
		
		for (String filepath : DFdic.keySet()) {
			Map filedic = DFdic.get(filepath);
			HashMap<String, Double> tfidfPair = null;
			for (Object key : filedic.keySet()) {
				 tfidfPair = new HashMap();
				double tf = (Double) filedic.get(key);

				double idf = idfDic.get((String) key);
				double tfidf = tf* Math.log(idf);
				System.out.println( key+"tf" + tf + "idf" + idf + "tfidf" + tfidf);
                tfidfPair.put((String) key, tfidf);
			}
            TFIDFdic.put(filepath, tfidfPair);
		}

	}

}