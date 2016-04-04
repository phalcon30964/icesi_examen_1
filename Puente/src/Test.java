
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Test {

    public static void main(String args[]) {

        Puente puente = new Puente();
        
        
        ArrayList<CochesIzqda> cochesIzq = new ArrayList<CochesIzqda>();
        ArrayList<CochesDcha> cochesDec = new ArrayList<CochesDcha>();

        for (int i = 1; i < 5; i++) {
            CochesIzqda izq = new CochesIzqda(puente, i);
            izq.start();
            cochesIzq.add(izq);
        }
        
        for (int i = 1; i < 5; i++) {
            CochesDcha der = new CochesDcha(puente, i);
            der.start();
            cochesDec.add(der);
        }
    }
}
