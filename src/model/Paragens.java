package model;

public enum Paragens {
    
        CENTRAL(15000), PANDORA(2000), RONIL(2000);
        
        private int tempoEspera;
        
        Paragens(int tempoEspera){
             this.tempoEspera = tempoEspera;
        }
        
        public int getTempoEspera(){
            return tempoEspera;
        }
        
}
