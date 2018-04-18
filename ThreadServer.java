/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ThreadServer{
    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(12345);
        int i=0;
        while(i<2){
            Socket ns = s.accept();
            new Thread(new ProtocoloServer(ns) {}).start();
            i++;
        }
        s.close();
    }
    
}
