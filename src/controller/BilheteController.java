package controller;

import dao.BilheteDao;
import dao.DataSource;
import java.util.List;
import model.Bilhete;
import model.Passageiro;

/**
 *
 * @author ELITEBOOK
 */
public class BilheteController {
      private static DataSource dataSource = new DataSource();
      private static Bilhete bilhete;
    public static boolean salvarBilhete(Passageiro p){
        BilheteDao dao = new BilheteDao(dataSource);
        
        bilhete = new Bilhete();
        
        bilhete.setPassageiro(p);
        
        dao.inserir(bilhete);
        
        
        return true;
    }
    
    public static boolean atualizarPrecario(float d1, float d2){
           BilheteDao dao = new BilheteDao(dataSource);
        
        bilhete = new Bilhete();
        bilhete.setPrecoD1(d1);
        bilhete.setPrecoD2(d2);
        
        
        dao.atualizarPrecario(bilhete);
        
        
        return true;

        
    }
    
       public static List<Bilhete> listaPrecario(){
        BilheteDao dao = new BilheteDao(dataSource);
        
        List<Bilhete> lista = dao.readPrecario();
        
        return lista;
    }
    
     public static Integer listaPassageiro(){
        BilheteDao dao = new BilheteDao(dataSource);
        
        int x = dao.readLastId();
        
        return x;
    }
}
