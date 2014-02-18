package enumwithstring;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formats formats = Formats.JPEG;
		System.out.println(formats);//out put JPEG
		FormatsWithString formatsWithString = FormatsWithString.JPEG;
		System.out.println(formatsWithString.toString());//out put still JPEG
	}

}
