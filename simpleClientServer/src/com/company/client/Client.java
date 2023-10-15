package com.company.client;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private  static BufferedReader reader;
    private  static BufferedReader in;
    private  static BufferedWriter out;

    public static  void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);


                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Enter msg for server:");
                String msg = reader.readLine();

                try {out.write(msg);
                    out.flush();

                    System.out.println(in.readLine());
                }  catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

            }
            finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
