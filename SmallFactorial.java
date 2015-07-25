package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SmallFactorial {
	public static void main(String...strings) throws NumberFormatException, IOException{
		BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(keyboard.readLine());
		while(n!=0){
			int uptoValue=Integer.parseInt(keyboard.readLine());
			calculateFactorial(uptoValue);
			n--;
		}
	}
	private static void calculateFactorial(int uptoValue) {
		BigInteger answer=BigInteger.ONE;
		boolean oddUptoValue=((uptoValue&1)==1);
		int tempUptoValue=uptoValue;
		if(oddUptoValue){
			tempUptoValue=uptoValue-1;
			}
		for(int i=1;i<=tempUptoValue/2;i++){
			long product=((tempUptoValue)-(i+1L))*i;
			answer=answer.multiply(BigInteger.valueOf(product));
		}
		if(oddUptoValue){
			answer=answer.multiply(BigInteger.valueOf(uptoValue));
		}
		System.out.println(answer);
	}

}
