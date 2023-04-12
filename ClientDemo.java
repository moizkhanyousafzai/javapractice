import java.io.*;
import java.net.*;

public class ClientDemo {
    public static void main(String args[]) throws Exception{
        //create client socket
        Socket s = new Socket("localhost", 6666);


        PrintStream ps = new PrintStream(s.getOutputStream());
        DataInputStream istream = new DataInputStream(s.getInputStream());
        String y;

        int x = 11;
        ps.println("Hello world");  // to check if server responds with error replace x with string;

        y = istream.readLine();
        System.out.println(y);

        ps.close();
        istream.close();

        s.close();
    }
}
