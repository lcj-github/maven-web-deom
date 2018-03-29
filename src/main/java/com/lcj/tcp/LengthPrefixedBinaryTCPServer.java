package com.lcj.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LengthPrefixedBinaryTCPServer {
	private int port = 10009;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 20;

    public LengthPrefixedBinaryTCPServer() throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {

                socket = serverSocket.accept();
                executorService.execute(new Handler2(socket));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new LengthPrefixedBinaryTCPServer().service();
    }

}
class Handler2 implements Runnable {
    private Socket socket = null;

    public Handler2(Socket socket) {
        this.socket = socket;
    }
    

    public  static  String bytesToHexString(byte[] src){   
        StringBuilder stringBuilder = new StringBuilder("");   
        if (src == null || src.length <= 0) {   
            return null;   
        }   
        for (int i = 0; i < src.length; i++) {   
            int v = src[i] & 0xFF;   
            String hv = Integer.toHexString(v);   
            if (hv.length() < 2) {   
                stringBuilder.append(0);   
            }   
            stringBuilder.append(hv);   
        }   
        return stringBuilder.toString();   
    }

   

    public void run() {
    	InputStream in = null;
        PrintWriter out = null;

        System.out.println("New connection accepted " + socket.getInetAddress()
                + ":" + socket.getPort());

        try {
        	byte[] buffer = new byte[1];
            byte[] lengthBuffer = new byte[2];
            StringBuilder sb = new StringBuilder();
            in = socket.getInputStream();
            int x = 0;
            int y = 0;
            while((x = in.read(buffer)) > -1){
                if(y < 2){
                    lengthBuffer[y] = buffer[0];

                } else {
                    sb.append(new String(buffer));
                }
                y++;
                if(buffer[x - 1] == 0x0a){
                    break;
                }
            }
            String recv = sb.toString();
            System.out.println(Integer.valueOf(bytesToHexString(lengthBuffer), 16));
            System.out.println(recv);


            out = new PrintWriter(socket.getOutputStream());
            out.write("Hello Client\r\n");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
