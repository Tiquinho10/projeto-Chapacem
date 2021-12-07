package model;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadParagens implements Runnable {
     private boolean parar;
     private boolean mudouParagem;
     private Paragens paragens;
     private int lotacaoAtual;
       private boolean volta;
      private final int lotacaoMax = 30;
       int cont = 0;
    
    public ThreadParagens(String matricula){
         this.paragens = Paragens.CENTRAL;
        
        //new Thread(this).start();
        new Thread(this, "Central-Ronil " + matricula).start();
        
    }
    
    public Paragens getParagens(){
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
    
    public synchronized void ida(){
        switch(this.paragens){
            case CENTRAL:
                   
                    subidarPassageiros(10);
                   this.paragens =  Paragens.PANDORA;
                   
                break; 
            case PANDORA:
                      descidaPassageiros(4);
                      subidarPassageiros(2);
                     this.paragens = Paragens.RONIL;

                break; 
           case RONIL:
                    //this.paragens = Paragens2.ALTO_MAE;
                    //descidaPassageiros();
               this.lotacaoAtual = 0;
                    subidarPassageiros(12);
                    cont++;
                    
                    System.out.println("terminal ida");
                break;
           default:
               break;
         }
        
    }
    
    public void volta(){
        switch(this.paragens){
            case CENTRAL:
                   this.lotacaoAtual = 0;
                   subidarPassageiros(10);
                  // this.paragens =  Paragens2.SHOPRITE;
                   System.out.println("terminal volta");
                   cont--;
                break; 
            case PANDORA:
                    descidaPassageiros(3);
                    subidarPassageiros(6);
                   
                     this.paragens = Paragens.CENTRAL;

                break; 
           case RONIL:
                   this.paragens = Paragens.PANDORA;
                    //descidaPassageiros();
                    subidarPassageiros(11);
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
    
    
    
    public synchronized void esperaVoltar() throws InterruptedException{
        while(!this.volta){
            wait();
        }
        
        this.volta = false;
    }
    
    public synchronized void voltar(){
        this.volta = true;
    }
    
    public synchronized void fecharParagem(){
        this.parar = true;
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
        
        if((this.lotacaoAtual >= lotacaoMax) && (this.lotacaoAtual > 0)){
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
