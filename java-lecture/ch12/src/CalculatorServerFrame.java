import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculatorServerFrame extends JFrame {
    private JTextArea logArea = new JTextArea();

    CalculatorServerFrame() {
        this.setTitle("계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        // contentPane.setLayout(new FlowLayout());
        contentPane.add(new JScrollPane(logArea));

        this.setSize(400, 200);
        this.setVisible(true);
        ServerThread serverThread = new ServerThread();
        serverThread.start();
    }

    class ServerThread extends Thread {

        @Override
        public void run() {
            ServerSocket serverSocket = null;
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(9997);
                while (true) {
                    socket = serverSocket.accept();
                    logArea.append("클라이언트 연결 됨 \n");
                    CalcThread calcThread = new CalcThread(socket);
                    calcThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    class CalcThread extends Thread {
        private BufferedReader bufferedReader = null;
        private BufferedWriter bufferedWriter = null;
        private Socket socket = null;

        CalcThread(Socket socket) {
            this.socket = socket;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String first = bufferedReader.readLine();
                    String operator = bufferedReader.readLine();
                    String second = bufferedReader.readLine();
                    int firstInt = Integer.parseInt(first);
                    int secondInt = Integer.parseInt(second);
                    int result = 0;
                    if (operator.equals("+")) {
                        result = firstInt + secondInt;
                    } else if (operator.equals("-")) {
                        result = firstInt - secondInt;
                    } else if (operator.equals("*")) {
                        result = firstInt * secondInt;
                    } else if (operator.equals("/")) {
                        result = firstInt / secondInt;
                    }
                    bufferedWriter.write(Integer.toString(result) + "\n");
                    bufferedWriter.flush();
                    logArea.append(first + operator + second + "=" + result + "\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new CalculatorServerFrame();
    }
}
