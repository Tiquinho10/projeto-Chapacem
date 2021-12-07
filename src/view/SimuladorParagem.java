package view;

import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Paragens2;
import model.ThreadParagens;
import model.ThreadParagens2;

public class SimuladorParagem {

    public static void main(String[] args) {
        
        Timer timer = new Timer();
        
        final long SEGUNDOS = (1000 * 5);
        
      
        //ThreadParagens paragem = new ThreadParagens();
           // System.out.println("nome " + nomeRota);
       // System.out.println(String.valueOf("xz " + rotas.getSelectedItem()).substring(0, 23));
        // String rota = nomeRota.substring(0, 22);
      //  if (rotas.getSelectedItem().equals("Alto-Mae-P.Combantentes")) {
       //if (String.valueOf(rotas.getSelectedItem()).substring(0, 26).equals("Alto-Mae-P.Combantentes")) {
      
        //System.out.println(rotas.getSelectedItem().getClass().getSimpleName());

       // if (rotas.getSelectedItem().equals("Alto-Mae-P.Combantentes")) {
      
        ThreadParagens2 paragem2 = new ThreadParagens2("x");
        ThreadParagens paragem = new ThreadParagens("mmc-02-02");
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

           TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
               
             paragem2.fecharParagem();
           
                System.out.println("ok");
            }
        };
        
        
       // timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS);
        timer.schedule(tarefa, SEGUNDOS);

       // System.out.println(threadSet.toString());

        for (Thread x : threadSet) {
            //if (x.getThreadGroup().getName().substring(0, 4).equals("Alto")) {
            if((x.getThreadGroup() == Thread.currentThread().getThreadGroup())  && (!x.getName().equals("DestroyJavaVM") && !x.getName().equals("AWT-EventQueue-0") && !x.getName().equals("mysql-cj-abandoned-connection-cleanup") && x.getName().substring(0, 4).equals("Cent"))){    
                
                System.out.println("thread atual: " + x.getName());
            }
           // System.out.println(x.getThreadGroup().getName().getClass().getSimpleName());
        }

        for (int i = 0; i < 2; i++) {
           // System.out.println("Paragem atual: " + paragem.getParagens());
            System.out.println("=======================");
            System.out.println("Paragem atual 2: " + paragem2.getParagens());
            // System.out.println("Nome da thread: " + paragem.getThreadName());

            try {
                paragem2.esperaMudar();
            } catch (InterruptedException ex) {
                Logger.getLogger(SimuladorParagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        paragem2.fecharParagem();
        
       
    }
}
