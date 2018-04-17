
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.*;
import java.net.*;
public class ServBan{
    public static void main(String[] args) throws IOException {
        int portNumber = 12345;
            ServerSocket servidor = new ServerSocket(portNumber);
            int i = 0;
            while(i<5){
                Socket cliente = servidor.accept();
                DataInputStream in = new DataInputStream(cliente.getInputStream());
                DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());     
                System.out.println("Porta 12345 aberta!");
                while(true){
                    String str = in.readUTF();
                    out.writeUTF(str);
                    if(str.equals("Bye"))
                        break;
                }                
                in.close();
                out.close();
                cliente.close();
                i++;
            }
            servidor.close();           
    }
}
