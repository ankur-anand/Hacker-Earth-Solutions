package hackerEarth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KaranAndEven {
	public static void main(String...strings ) throws NumberFormatException, IOException{
		BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
		int evenTestValue=0;
		do{
			evenTestValue=Integer.parseInt(keyboard.readLine());
			checkEven(evenTestValue);
			}while (evenTestValue!=-1);
	}

	private static void checkEven(int evenTestValue) {
		// TODO Auto-generated method stub
		if((evenTestValue&1)==0){
			System.out.println(evenTestValue);
		}
	}
}
