import java.util.regex.*;

/**
 * 
 */

/**
 * @author bliu
 * 
 */
public class RegxSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String regxId = "[0-9a-zA-Z*_-]{22}";
		String regxUUID = "[0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{12}";
		String regxAll = "(" + regxId + "|" + regxUUID + ")";
		
		Pattern patternId = Pattern.compile(regxId);
		Pattern patternUUID = Pattern.compile(regxUUID);
		Pattern patternAll = Pattern.compile(regxAll);
		
		String id = "ax*hZGpAj5YlPTxxsKPS1a";
		String uuid = "098c0a52-e5f5-40e0-af81-8f1a5b0d9577";
		
		Matcher matcher = patternId.matcher(id);
		System.out.println(matcher.matches());
		
		 matcher = patternUUID.matcher(uuid);
		System.out.println(matcher.matches());
		
		 matcher = patternAll.matcher(id);
		System.out.println(matcher.matches());
		 matcher = patternAll.matcher(uuid);
		System.out.println(matcher.matches());


	}

}
