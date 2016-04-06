
import java.util.logging.Level;
import java.util.logging.Logger;

public class CochesDcha extends Thread {

    Puente puente;
    int id;

    public CochesDcha(Puente puente, int id) {
        this.puente = puente;
        this.id = id;
    }

    public void run() {

        while (true) {

            try {
                puente.subirPuenteDerecha();
            } catch (InterruptedException ex) {
                Logger.getLogger(CochesDcha.class.getName()).log(Level.SEVERE, null, ex);
            }

            int t = (5);
            System.out.println("CocheDerecha" + id + " sube el puente a las "+System.nanoTime());


            try {
               sleep(t * 1000);
            } catch (InterruptedException e) {
            }

            try {
                puente.bajarPuenteDerecha();
            } catch (InterruptedException ex) {
                Logger.getLogger(CochesDcha.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("CocheDerecha" + id + " baja el puente a las "+System.nanoTime());

        }

    }
}
