/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import model.Semi_ColectivoB;

/**
 *
 * @author ELITEBOOK
 */
public class TesteRun {
    
    public static void main(String[] args) throws InterruptedException {
        // ThreadParagens paragem = new ThreadParagens("mmc-02-02");
         Semi_ColectivoB chapa = new Semi_ColectivoB("mmc-02-02", 1);
         Semi_ColectivoB chapa2 = new Semi_ColectivoB("mmc-01-05", 0);
       //  Semi_ColectivoA chapa3 = new Semi_ColectivoA("mmc-02-02", 1);
        // Semi_ColectivoA chapa4 = new Semi_ColectivoA("mmc-01-05", 0);
         Random generate = new Random();
        
         for(int i = 0; i < 5; i++){
             /*
            System.out.println(chapa.getThreadName() + " atual: " +chapa.getParagens());
             System.out.println(chapa2.getThreadName() + " atual: " + chapa2.getParagens());
             chapa.esperaMudar();
             chapa2.esperaMudar();
             System.out.println("===================================");
             */
             int number = generate.nextInt(20);
             System.out.println(number);
            
            
         }
         System.out.println("fim");
      chapa.fecharParagem();
      chapa2.fecharParagem();
}
}