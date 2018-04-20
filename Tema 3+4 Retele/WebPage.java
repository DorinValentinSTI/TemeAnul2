
import java.net.*;

import java.io.*;

public class WebPage {
	public static void main(String[] args) throws Exception {

		URL oracle = new URL("http://www.yoda.ro/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		PrintWriter os = new PrintWriter("C:\\Users\\Valy_STI\\Desktop\\Retele_Tema3\\breaking.txt");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			os.println(inputLine);
		}
		in.close();
	}
}