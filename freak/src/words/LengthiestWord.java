package words;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LengthiestWord {

	public static void main (String Args[]) throws IOException{

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter String");
	    String s = br.readLine();
	    s=s+" ";
	    s.toLowerCase();
	    String word="";
	    String max="";
	    int count=0;

	    for(int i=0; i<s.length();i++){
	        char ch = s.charAt(i);
	        while(ch!=' '){
	        	 word+=ch;
	        	 ch = s.charAt(++i);
	 	   }
	      
	        if(word.length()>max.length()){
	            max=word;
	            word="";
	            count++;
	        }
	        else {
	        	count++;
	        	word="";
	        }
	    }
	    System.out.println(max+" , "+count);
	}
}

