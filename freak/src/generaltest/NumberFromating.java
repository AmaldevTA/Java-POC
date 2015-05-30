package generaltest;

import java.text.DecimalFormat;

public class NumberFromating {
	
	public static void main(String[] args) {
		
		double xx =235.5320002989;
		
		DecimalFormat format_2Places = new DecimalFormat("0.0000000");

		double TotalPrice = Double.valueOf(format_2Places.format(xx));
		
		String s = String.format("%.7f", xx);
		
		System.out.println(s);
		System.out.println(TotalPrice);
	}

}
