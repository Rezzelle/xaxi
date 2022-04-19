import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class server {
	private static ServerSocket serverSocket;

	@SuppressWarnings("null")
	public static void main (String[] args) throws IOException{
		Socket s = new Socket("localhost", 9090);
		System.out.println("Waiting for" + 9090);
		String line = null;
		String status = " ";
		
		while(true) {
			try (Socket socket = serverSocket.accept()){;
		InputStream is = s.getInputStream(); 
		BufferedReader cn = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		{ 
			System.out.println("Connected");
					}
		String line1 ;
		while ((line1 = cn.readLine()) != null)  {
			System.out.println("Server Meassage Recieved:" + line1 + ". To Client");
			out.println("line1");
			
			if(line.equals("Hi")) {
				break;
			}
			System.out.println("End connection? Y/N:");
			
			PrintWriter pw= new PrintWriter(s.getOutputStream(), true);
			status = cn.readLine();
			pw.println(status);
		
			if (status.equals("Y")) 
				s.close ();
				break;
			}
		System.out.println("Goodbye...");
		}
		
	}
}
}