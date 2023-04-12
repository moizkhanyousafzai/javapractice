import java.io.*;
import java.net.*;
public class ServerDemo {
    public static void main(String args[]) throws Exception{

        //create server socket
        ServerSocket ss = new ServerSocket(6666);

        //connect it to client socket
        while(true) {
            Socket s = ss.accept();
            System.out.println("Connection established");

            PrintStream ps = new PrintStream(s.getOutputStream());

            DataInputStream istream = new DataInputStream(s.getInputStream());


            String input = istream.readLine();

            try {
                int num = Integer.parseInt(input);
                if (num % 2 == 0) {
                    ps.println("Even received");
                } else {
                    ps.println("odd received");
                }
            }catch(NumberFormatException e){
                ps.println("Invalid input");
            }

            ps.close();
            istream.close();
            s.close();
        }

    }

}
