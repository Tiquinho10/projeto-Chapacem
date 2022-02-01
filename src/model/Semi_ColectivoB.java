package model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * classe que simula a movimentacao de um transporte 
  * para o efeito foram usadas Threads(Processos)
  */
public class Semi_ColectivoB extends Thread {
     private boolean parar;
     private boolean mudouParagem;
     private Paragens paragens;
     private int lotacaoAtual;
       private boolean volta;
      private final int lotacaoMax = 40;
      private int cont = 0;
      private Random random = new Random();
       
    
       /**
      * contrutor da classe que inicia a thread
      * @param matricula - recebe a matricula do veiculo
      */
    public Semi_ColectivoB(String matricula, int terminal){
      
        setCont(terminal);
         if(cont >= 1){
             this.paragens = Paragens.RONIL;
             
         }else{
             this.paragens = Paragens.CENTRAL;
            
         }
        
         this.setName( "Central-Ronil " + matricula);
         this.start();
        
      
        
    }
    
    //retorna a paragem atual
    public  Paragens getParagens(){
          
        return this.paragens;
    }

    public int getLotacaoMax() {
        return lotacaoMax;
    }
    
    
    
    @Override
    public void run() {
       
        while(!parar){
        
            try {
                Thread.sleep(this.paragens.getTempoEspera());
                this.mudarParagem();
                
            } catch (InterruptedException ex) {
                  System.out.println(ex.getMessage());
            }
    }
    }
    
    public synchronized void ida(){
        switch(this.paragens){
            case CENTRAL:
                   
                    entradaPassageiros(20);
                   this.paragens =  Paragens.PANDORA;
                   
                break; 
            case PANDORA:
                      descidaPassageiros(10);
                      entradaPassageiros(11);
                     this.paragens = Paragens.RONIL;

                break; 
           case RONIL:
                    //this.paragens = Paragens2.ALTO_MAE;
                    //descidaPassageiros();
               this.lotacaoAtual = 0;
                    entradaPassageiros(6);
                    cont++;
                    
                    //System.out.println("terminal ida");
                break;
           default:
               break;
         }
        
    }
    
    public void volta(){
        switch(this.paragens){
            case CENTRAL:
                   this.lotacaoAtual = 0;
                   entradaPassageiros(20);
                  // this.paragens =  Paragens2.SHOPRITE;
                  // System.out.println("terminal volta");
                   cont--;
                break; 
            case PANDORA:
                    descidaPassageiros(14);
                    entradaPassageiros(10);
                   
                     this.paragens = Paragens.CENTRAL;

                break; 
           case RONIL:
                   this.paragens = Paragens.PANDORA;
                    descidaPassageiros(5);
                    entradaPassageiros(15);
                    //System.out.println("terminal");
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
    public synchronized void entradaPassageiros(int ran){
           int nr = random.nextInt(ran);
        
          if(this.lotacaoAtual >= lotacaoMax){
            System.out.println("lotacao cheia");
        }else{
            this.lotacaoAtual+=nr;
        }
        
       
        
        
    }
    
     public synchronized void descidaPassageiros(int ran){
            int nr = random.nextInt(ran);
        if((this.lotacaoAtual >= lotacaoMax) && (this.lotacaoAtual > 0)){
            this.lotacaoAtual-=nr;
        }else{
           // System.out.println("ja nao pode descer");
        }
        
       
    }
    
    public int getLotacaoAtual(){
        return lotacaoAtual;
    }
    
    public String getThreadName(){
        
        return this.getName();
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
