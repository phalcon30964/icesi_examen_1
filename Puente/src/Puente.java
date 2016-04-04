
import java.util.concurrent.Semaphore;

public class Puente {

    int carros;
    Semaphore disponibilidadCoches;
    Semaphore mutex;
    Semaphore permisoPasar;
    Semaphore puente;

    public Puente() {

        puente = new Semaphore(1, true);
        disponibilidadCoches = new Semaphore(10, true);

        carros = 0;

        mutex = new Semaphore(1, true);
        permisoPasar = new Semaphore(1, true);

    }

    public void entrarDerecha() throws InterruptedException {
        permisoPasar.acquire(); // si un carro de la izquierda aparece ya no pueden mas lo de la derecha encolarse

        mutex.acquire();//para que entre carros no modifique todos al tiempo la variable

        disponibilidadCoches.acquire(); // quita un espacio del ṕuente------------------------

        carros = carros + 1; // entra el carro al puente
        if (carros == 1) {
            puente.acquire();// si es el primero de este tipo coge el puente para los de la derecha
        }
        System.out.println(carros);

        mutex.release();

        permisoPasar.release();
    }

    public void salirDerecha() throws InterruptedException {

        mutex.acquire(); //para que entre carros no modifique todos al tiempo la variable

        carros = carros - 1; // carro abandona el puente
        disponibilidadCoches.release(); //devuelve un espacio al puente-----------------------

        System.out.println(carros);

        mutex.release();
        
        if (carros == 0) { // Si esta adentro de mutex se da mas importancia al escritor
            puente.release();
        }
    }

    public void entrarIzquierda() throws InterruptedException {
        permisoPasar.acquire(); // pide derecho a pasar por el puente
        //puente.acquire();

        mutex.acquire();//para que entre carros no modifique todos al tiempo la variable
        
        if (carros == 0) {
            puente.acquire();// si es el primero de este tipo coge el puente para los de la derecha
        }
        
        disponibilidadCoches.acquire(); // quita un espacio del ṕuente------------------------
        carros = carros + 1; // entra el carro al puente

        System.out.println(carros);

        mutex.release();

    }

    public void salirIzquierda() throws InterruptedException {
        
        mutex.acquire(); //para que entre carros no modifique todos al tiempo la variable

        carros = carros - 1; // carro abandona el puente
        disponibilidadCoches.release(); //devuelve un espacio al puente-----------------------

        System.out.println(carros);

        mutex.release();
        
        if (carros == 0) { // Si esta adentro de mutex se da mas importancia al escritor
            puente.release();
            permisoPasar.release();
        }
        
    }
}
