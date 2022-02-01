package model;

public enum Paragens2 {
    
        ALTO_MAE(5000), SHOPRITE(5000), PRACA(5000);
        
        private int tempoEspera;
        
        Paragens2(int tempoEspera){
             this.tempoEspera = tempoEspera;
        }
        
        public int getTempoEspera(){
            return tempoEspera;
        }
        
        
}
