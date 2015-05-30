package strings;



public class FormatedOutPut {

	public static void main(String[] args) {
		
		System.out.println(String.format("%.2f", 125.23456d));
		System.out.println(String.format("%.2f", 1.23456d).replaceFirst("^[^.//]+", ""));
		
		
		
	}

	
	
}
