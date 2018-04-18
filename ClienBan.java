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
import java.util.*;
public class ClienBan {
    public static void main(String[] args) throws IOException{
        String hostName = "127.0.0.1";
        Socket cliente = new Socket(hostName,12345);
        System.out.println("Conectado com sucesso:"+hostName + "12345");
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream in = new DataInputStream(cliente.getInputStream());
        DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
        while(true){
            String str = stdIn.readLine();
            out.writeUTF(str);
            System.out.println("Server says: "+in.readUTF());
            if(str.equals("Bye"))
                break;
        }
        in.close();
        out.close();
        cliente.close();   
    }   
}