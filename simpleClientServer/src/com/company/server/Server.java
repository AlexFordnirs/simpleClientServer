package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private  static BufferedReader in;
    private  static BufferedWriter out;

/*    public interface Comands
    {
         public void revie();

    }
    public class SummComand implements Comands
    {
        private int first,two,last;
        public SummComand(int first,int two)
        {
            first=this.first;
            two=this.two;
        }
     @Override
     public void revie()
     {
         last=first+two;
         out.write(first+"+"+two+"="+last);
     }
    }
    public class MinysComand implements Comands
    {   private int first,two,last;
        public MinysComand(int first,int two)
        {
            first=this.first;
            two=this.two;
        }
        @Override
        public void revie()
        {   last=first+two;
            out.write(first+"+"+two+"="+last);
        }
    }
    public class YmnojitComand implements Comands
    {    private int first,two,last;
        public YmnojitComand(int first,int two)
        {
            first=this.first;
            two=this.two;
        }
        @Override
        public void revie()
        {
            last=first+two;
            out.write(first+"+"+two+"="+last);
        }
    }*/
 /*   public class DelliteComand implements Comands
    {    private int first,two,last;
        public DelliteComand(int first,int two)
        {
            first=this.first;
            two=this.two;
        }
        @Override
        public void revie()
        {
            last=first+two;
            out.write(first+"+"+two+"="+last);
        }
    }*/

    public static  void main(String[] args){
        try {
            serverSocket = new ServerSocket(4004);
            System.out.println("Server start!");

            clientSocket = serverSocket.accept();

                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    System.out.println("Client send:");
                    String str;
                    str=in.readLine();
                    out.write(str);
   /*                 int [] masis= new int [3];
                    int i=0;
                    for (String retval : str.split(",")) {
                        System.out.println(retval);
                        if(i!=2){
                        masis[i]=Integer.parseInt(retval);}
                    i++;
                    }
                    i=0;
                    switch (masis[2]) {
                        case '+':
                            i=masis[0]+masis[1];
                            break;
                        case '-':
                            i=masis[0]-masis[1];
                            break;
                        case '*':
                            i=masis[0]*masis[1];
                            break;
                        case '/':
                            i=masis[0]/masis[1];
                            break;
                    }
                    out.write(masis[0]+"+"+masis[1]+"="+i);*/
                    out.flush();
                }
                finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
