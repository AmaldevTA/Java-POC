package generaltest;

public class NamedBlock {

	public static void main(String[] args) {
		 outerloop:{
			    	for (int i=0; i < 5; i++) {
			    		for (int j=0; j < 5; j++) {
			    			
			    			System.out.println("inner loop");
			    			break outerloop;
			    		}
			    		
			    		System.out.println("outer loop");
			    	 }
				  }
			    System.out.println("Done");
	}
}
