package generaltest;

import java.math.BigInteger;

public class Big_Integer {
	
	public static void main(String[] args) {
		
		BigInteger mynumber = new BigInteger("1000000000000000000");
		
		int x = 5;

		
		System.out.println(mynumber.multiply(BigInteger.valueOf(x)));
	}

}
