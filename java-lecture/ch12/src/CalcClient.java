import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            socket = new Socket("192.168.0.83", 9999);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                System.out.print("보내기 >>>");
                String outputMsg = scanner.nextLine();
                bufferedWriter.write(outputMsg + "\n");
                bufferedWriter.flush();
                String inputMsg = bufferedReader.readLine();
                System.out.println("서버 : " + inputMsg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
