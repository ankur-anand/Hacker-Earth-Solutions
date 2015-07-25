package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trailingZeros {
	
	public static void main(String...strings) throws NumberFormatException, IOException{
		Object a=1;
		//System.out.println(convertingToType(a).getClass().isPrimitive());
	}
	
	private static <T> int convertingToType(Object value){
		if(value.getClass().getSimpleName().equals("Integer")) {
			int intValue = (Integer) value;
			return intValue;
			}
		
		return 0;
		
	}
}
