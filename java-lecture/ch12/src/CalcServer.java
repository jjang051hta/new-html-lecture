import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("나는 서버 연결 대기중...");
            socket = serverSocket.accept();
            System.out.println("연결 되었습니다.");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String inputMsg = bufferedReader.readLine();
                System.out.println("클라이언트 : " + inputMsg);
                System.out.print("보내기 >>>");
                String outputMsg = scanner.nextLine();
                bufferedWriter.write(outputMsg + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}