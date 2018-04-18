/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
class MyThread extends Thread{
    private String message;
    
    public MyThread(String m) {message = m;}
    
    public void run(){
        for(int r=0; r<4;r++)
            System.out.println(message);
    }
    
}
public class ThreadDemo {
    
    public static void main(String[] args){
        //MyThread t1,t2;
        MyThread t1 = new MyThread("Primeiro thread");
        MyThread t2 = new MyThread("Segundo thread");
        t1.start();
        t2.start();
     
    }
    

}

