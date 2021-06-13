import com.sergeev.Phone;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000)) {
                Socket socket = new Socket("127.0.0.1", 8000);

            System.out.println("Connected to server");
            String reqest = "Samara";
            System.out.println("Request: " + reqest);
            phone.writeLine(reqest);
            String response = phone.readLine();
            System.out.println("Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
