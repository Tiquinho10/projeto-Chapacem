package model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

 /**
  * classe que simula a movimentacao de um transporte 
  * para o efeito foram usadas Threads(Processos)
  */
public class Semi_ColectivoA extends Thread{
     private boolean parar;
     private boolean mudouParagem;
     private Paragens2 paragens;
     private int lotacaoAtual;
     private final int lotacaoMax = 40;
     private boolean volta;
     private int cont = 0;
     private Random random = new Random();
    
     /**
      * contrutor da classe que inicia a thread
      * @param matricula - recebe a matricula do veiculo
      */
    public Semi_ColectivoA(String matricula, int terminal){
         setCont(terminal);
         if(cont >= 1){
             this.paragens = Paragens2.PRACA;
             System.out.println("Terminal Praca");
         }else{
             this.paragens = Paragens2.ALTO_MAE;
             System.out.println("Terminal Alto-Mae");
         }
             
         
        
        //new Thread(this).start();
        this.setName("Alto-Mae-P.Combantentes " + matricula);
        this.start();
        System.out.println("Thread iniciada...");
        
    }
    
    //retorna a paragem atual
    public Paragens2 getParagens(){
        
        return this.paragens;
    }
    //retona a lotacao maxima do transporte
    public int getLotacaoMax() {
        return lotacaoMax;
    }
    
    
    //metodo executado ao instaciar a classe
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
    
    
    //metodo que representa a trajectoria de um transporte
    public synchronized void ida(){
        switch(this.paragens){
            case ALTO_MAE:
                   
                   entradaPassageiros(20);
                   this.paragens =  Paragens2.SHOPRITE;
                   
                break; 
            case SHOPRITE:
                    descidaPassageiros(10);
                    entradaPassageiros(14);
                    
                     this.paragens = Paragens2.PRACA;

                break; 
           case PRACA:
                    
                    //descidaPassageiros();
               this.lotacaoAtual = 0;
                    entradaPassageiros(6);
                    cont++;
                    
                   // System.out.println("terminal ida");
                break;
           default:
               break;
         }
        
    }
     //metodo que representa a trajectoria de um transporte
    public void volta(){
        switch(this.paragens){
            case ALTO_MAE:
                   this.lotacaoAtual = 0;
                   entradaPassageiros(20);
                  // this.paragens =  Paragens2.SHOPRITE;
                  // System.out.println("terminal volta");
                   cont--;
                break; 
            case SHOPRITE:
                      descidaPassageiros(15);
                      entradaPassageiros(10);
                     this.paragens = Paragens2.ALTO_MAE;

                break; 
           case PRACA:
                   this.paragens = Paragens2.SHOPRITE;
                    descidaPassageiros(13);
                    entradaPassageiros(15);
                    //System.out.println("terminal");
                break;
           default:
               break;
         }
    }
    
    /**
     * metodo para notificar a thread para mudar a localizacao
     */
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
    
    /**
        Metodo para concluir a execucao da thread 
    */
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
    
    //metodo que simula a entrada de passageiros no transporte
    public synchronized void entradaPassageiros(int ran){
          int nr = random.nextInt(ran);
        
          if(this.lotacaoAtual >= lotacaoMax){
            System.out.println("lotacao cheia");
        }else{
            this.lotacaoAtual+=nr;
        }
        
       
        
        
    }
     //metodo que simula a saida de passageiros no transporte
     public synchronized void descidaPassageiros(int ran){
        int nr = random.nextInt(ran);
        if((this.lotacaoAtual >= lotacaoMax) && (this.lotacaoAtual >= 0)){
            this.lotacaoAtual-=nr;
        }else{
           // System.out.println("ja nao pode descer");
        }
        
        
    }
    
     //retorna a lotacao atual
    public int getLotacaoAtual(){
        return lotacaoAtual;
    }
    //retorna o nome da thread
    public String getThreadName(){
        
        //return Thread.currentThread().getName();
        return this.getName();
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
