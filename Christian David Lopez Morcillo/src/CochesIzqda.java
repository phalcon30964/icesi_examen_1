
import java.util.logging.Level;
import java.util.logging.Logger;


public class CochesIzqda extends Thread {

    Puente puente;
    int id;

    public CochesIzqda(Puente puente, int id) {
        this.puente = puente;
        this.id = id;
    }

    public void run() {

        while (true) {

            try {

                try {
                    puente.subirPuenteIzquierda();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CochesIzqda.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                int t = (5);
                System.out.println("CocheIzquierda" +id+" sube puente a las "+System.nanoTime());
                
                try {
                    sleep(t*1000);
                }catch (InterruptedException e) {
                }
                
                puente.bajarPuenteIzquierda();
                
                System.out.println("CocheIzquierda" +id+" baja puente a las "+System.nanoTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(CochesIzqda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
