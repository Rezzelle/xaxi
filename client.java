import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
	private final static String hostname = "host";
	private final static int LOCALHOST = 9090;
	
	public static void main (String[] args, BufferedReader cn) throws IOException  {
		try(Socket clientSocket =  new Socket(hostname, LOCALHOST)) {
			InputStream is = clientSocket.getInputStream(); 
			new BufferedReader(new InputStreamReader(is));
			new PrintWriter(clientSocket.getOutputStream(), true);
			{ 
				System.out.println("Connected to.." + hostname + " dayun" + LOCALHOST );
				
				String data = "Hi";
				System.out.println("To server: \n" + data );
				System.out.println("data");
				String line1 ;
				
		while((line1 = cn.readLine()) != null)  {
			System.out.println("Meassage Recieved:" + line1);	
			System.out.println("End Connection? Type Y/N");

			PrintWriter pw= new PrintWriter(is.getOutputStream(), true);
			data = cn.readLine();
			pw.println(data);
		
			if (data.equals("Y")) 
				is.close ();
				break;
			}
		System.out.println("Goodbye..."); }


