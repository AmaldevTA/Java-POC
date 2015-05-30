package strings;

public class TwoDStringArray {
	
	static String[][] index = new String[1][3];
	
	public static void main(String[] args) {
		
		index[0][0] = "amal";
		index[0][1] = "dev";
				
		int x = 0;
	    boolean cond = false;
	    String var = "dev";
	    while((index[0][x] != null) && (cond != true))
	    {
	    	
			if (index[0][x++].equals(var) == true)
	        {
	            cond = true;
	            x--;
	        }
	    }
	    
	    System.out.println("x = " +x+ "  val = " +index[0][x] + "    "+ cond);
	}

}
