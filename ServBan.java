
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
import java.io.IOException;
import java.net.*;
//import Conta;


public class ServBan{
    Conta[] conta = new Conta[3];
    conta[0] = new Conta();
    conta[1] = new Conta(104,500);
    //Conta conta = new Conta();
    Conta conta1 = new Conta(101,(float) 250.0);
    Conta conta2 = new Conta(102,(float) 350.0);
    Conta contaDoLula = new Conta(103,(float) 500000000);
    //
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
