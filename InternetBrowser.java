/* time 1.1632 sec */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InternetBrowser {
	public static void main(String... strings) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		int t = Integer.parseInt(keyboard.readLine());
		while (t != 0) {
			String s = keyboard.readLine();

			int len = s.length();
			String sub = s.substring(4, len - 4);
			ratioFinding(sub, len);
			t--;
		}
	}

	public static void ratioFinding(String s, int len) {
		int count=0;
		int lenOfS=s.length();
		for(int j=0;j<lenOfS;j++){
       		if(s.charAt(j)=='a'||s.charAt(j)=='e'||s.charAt(j)=='i'||s.charAt(j)=='o'||s.charAt(j)=='u')
       		count++;
       	}
		System.out.println(lenOfS-count + 4 + "/" + len);

	}

}
