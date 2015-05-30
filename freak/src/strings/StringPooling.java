package strings;

public class StringPooling {

	public static void main(String[] args) {
		
		String str1 = "amal";
		String str2 = "amal";
		String str3 = new String("amal");
		
		System.out.println( str1 == str2 );
		System.out.println( str1 == str3 );
		
		
		System.out.println( str1.hashCode() == str2.hashCode() );
		System.out.println( str2.hashCode() == str3.hashCode() );
	}

}
