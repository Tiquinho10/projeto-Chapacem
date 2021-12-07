package model;

public enum Paragens2 {
    
        ALTO_MAE(2000), SHOPRITE(3000), PRACA(4000);
        
        private int tempoEspera;
        
        Paragens2(int tempoEspera){
             this.tempoEspera = tempoEspera;
        }
        
        public int getTempoEspera(){
            return tempoEspera;
        }
        
        
}
