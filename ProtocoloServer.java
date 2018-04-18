
import java.io.*;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */

public abstract class ProtocoloServer implements Runnable{
    Socket s;
    
    public ProtocoloServer(Socket ns){
        s = ns;
    }
    @Override
    public void run(){
        try(
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
                ){
        while(true){
            String str = in.readUTF();
            System.out.println("Client says "+str);
            out.writeUTF(str);
            if(str.equals("Bye"))
                break;
        }
        in.close();
        out.close();
        s.close();
        }catch (IOException e){
            System.out.println("Exception caught when trying to listen on port "
            + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}