import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
    private JTextField sender = null;
    private Receiver receiver = null;

    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    private Socket socket = null;

    ChatClient() {
        this.setTitle("까까오 톡");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        sender = new JTextField();
        contentPane.add(sender, BorderLayout.SOUTH);
        receiver = new Receiver();
        contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);

        sender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = sender.getText();
                try {
                    bufferedWriter.write(msg + "\n");
                    bufferedWriter.flush();
                    receiver.append("\n client : " + msg);
                    sender.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        try {
            socket = new Socket("localhost", 9998);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            System.out.println("서버 안켰음");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        this.setSize(400, 500);
        this.setVisible(true);
        Thread thread = new Thread(receiver);
        thread.start();

    }

    class Receiver extends JTextArea implements Runnable {

        @Override
        public void run() {
            String msg = null;
            try {
                msg = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.append("\n server : " + msg);
            // 스크롤 이동
            int scrollPosition = this.getText().length();
            this.setCaretPosition(scrollPosition);
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
