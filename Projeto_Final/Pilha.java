/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
public class Pilha{
    private int dados[];
    private int topo;
    private int tamMax;
    
    public Pilha(int n){
        tamMax = n;
        dados = new int[tamMax];
        topo = -1;
    }
    
    public boolean vazia(){
        if(topo == -1)
            return true;
        else
            return false;
    }
    
    public boolean cheia(){
        if(topo == (tamMax-1))
        return true;
        else
        return false;
    }
    
    public int tamanho(){
        return topo+1;
    }
    public int top(){
        if(vazia())
        return -1;
     return dados[topo];
    }
    
    public boolean push(int valor){
        if(cheia())
            return false;
        topo++;
        dados[topo] = valor;
        return true;
    }
    
    public int pop(){
        if(vazia())
            return -1;
        
        int valor = dados[topo];
        topo--;
        return valor;
    }
}
