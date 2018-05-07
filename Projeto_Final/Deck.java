/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Deck{
    public static void main(String[] args) throws IOException{
        Pilha pilhaDeck = new Pilha(84);
        Random r = new Random();
        String s = "";
        int[] listaDeck = new int[84];
        int n = r.nextInt(10)+1;
        int cont=0;
        try{
            FileReader arq = new FileReader("C:\\Users\\KAMINARI\\Documents\\NetBeansProjects\\Empilha_deck\\Lista.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            for(int i=0;i<100;i++){
                s = lerArq.readLine();
                if(n<=9){
                    if(s.startsWith("0"+n+":"))
                        break;
                }
                else if(n>9){
                    if(s.startsWith(n+":"))
                        break;
                }
            }
            String[] lista = s.substring(4).split(",");
            for(int i=0;i<84;i++){
                listaDeck[i] = Integer.parseInt(lista[i]);
            }
            for(int i=0;i<84;i++){
                System.out.print(listaDeck[i]+" ");
            }
            
            for(int i=0;i<84;i++){
                pilhaDeck.push(listaDeck[i]);
            }
            System.out.println("Tamanho:"+pilhaDeck.tamanho());
            
            System.out.println();
        }catch(IOException e){
            System.err.printf("Erro na abertura do arquivo");
            e.getMessage();
        }
    }
}
