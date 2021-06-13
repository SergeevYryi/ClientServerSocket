import com.sergeev.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args)  {

        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started!");
            while (true)
                try (Phone phone = new Phone (server)) {


            String request = phone.readLine();
            System.out.println("Request: " + request);
            String response = "HELLO FROM SERVER: " + request.length();
            System.out.println("Response: " + response);
            Thread.sleep(4000);
            phone.writeLine(response);
        } catch (NullPointerException | InterruptedException e) {
                    e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
