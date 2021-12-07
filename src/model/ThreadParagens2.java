package model;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadParagens2 implements Runnable {
     private boolean parar;
     private boolean mudouParagem;
     private Paragens2 paragens;
     private int lotacaoAtual;
     private final int lotacaoMax = 10;
     private boolean volta;
     int cont = 0;
    
    public ThreadParagens2(String matricula){
         this.paragens = Paragens2.ALTO_MAE;
        
        //new Thread(this).start();
        new Thread(this, "Alto-Mae-P.Combantentes " + matricula).start();
        
    }
    
    public Paragens2 getParagens(){
        return paragens;
    }

    public int getLotacaoMax() {
        return lotacaoMax;
    }
    
    
    
    @Override
    public void run() {
        System.out.println("Nome da thread" + Thread.currentThread().getName()); 
        while(!parar){
        
            try {
                Thread.sleep(this.paragens.getTempoEspera());
                this.mudarParagem();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadParagens.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    
    //ver sobre wait e notifi
    public synchronized void ida(){
        switch(this.paragens){
            case ALTO_MAE:
                   
                   subidarPassageiros(20);
                   this.paragens =  Paragens2.SHOPRITE;
                   
                break; 
            case SHOPRITE:
                    descidaPassageiros(7);
                    subidarPassageiros(2);
                    
                     this.paragens = Paragens2.PRACA;

                break; 
           case PRACA:
                    //this.paragens = Paragens2.ALTO_MAE;
                    //descidaPassageiros();
               this.lotacaoAtual = 0;
                    subidarPassageiros(4);
                    cont++;
                    
                    System.out.println("terminal ida");
                break;
           default:
               break;
         }
        
    }
    
    public void volta(){
        switch(this.paragens){
            case ALTO_MAE:
                   this.lotacaoAtual = 0;
                   subidarPassageiros(12);
                  // this.paragens =  Paragens2.SHOPRITE;
                   System.out.println("terminal volta");
                   cont--;
                break; 
            case SHOPRITE:
                      descidaPassageiros(5);
                      subidarPassageiros(8);
                     this.paragens = Paragens2.ALTO_MAE;

                break; 
           case PRACA:
                   this.paragens = Paragens2.SHOPRITE;
                    descidaPassageiros(2);
                    subidarPassageiros(12);
                    System.out.println("terminal");
                break;
           default:
               break;
         }
    }
    
    public synchronized void mudarParagem(){
        
         if(cont == 0){
             ida();
         }else{
             volta();
         }
         this.mudouParagem = true;
         notify();
    }
    
    public synchronized void esperaMudar() throws InterruptedException{
        while(!this.mudouParagem){
            wait();
        }
        
        this.mudouParagem = false;
    }
    
    public synchronized void fecharParagem(){
        this.parar = true;
        
        
    }
    
    public synchronized void esperaVoltar() throws InterruptedException{
        while(!this.volta){
            wait();
        }
        
        this.volta = false;
    }
    
    public synchronized void voltar(){
        this.volta = true;
    }
    
    //fazer essa funcao para simular a entrada de passageiros no auto carro
    public synchronized void subidarPassageiros(int nr){
          
        
          if(this.lotacaoAtual >= lotacaoMax){
            System.out.println("lotacao cheia");
        }else{
            this.lotacaoAtual+=nr;
        }
        
       
        
        System.out.println("lotacao atual: " + this.lotacaoAtual + "/" + lotacaoMax);
    }
    
     public synchronized void descidaPassageiros(int nr){
        
        if((this.lotacaoAtual >= lotacaoMax) && (this.lotacaoAtual >= 0)){
            this.lotacaoAtual-=nr;
        }else{
            System.out.println("ja nao pode descer");
        }
        
        System.out.println("lotacao atual: " + this.lotacaoAtual + "/" + lotacaoMax);
    }
    
    public int getLotacaoAtual(){
        return lotacaoAtual;
    }
    
    public String getThreadName(){
        
        return Thread.currentThread().getName();
    }
}
