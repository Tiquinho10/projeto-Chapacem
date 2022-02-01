package model;

public enum Paragens {
    
        CENTRAL(5000), PANDORA(5000), RONIL(5000);
        
        private int tempoEspera;
        
        Paragens(int tempoEspera){
             this.tempoEspera = tempoEspera;
        }
        
        public int getTempoEspera(){
            return tempoEspera;
        }
        
}
