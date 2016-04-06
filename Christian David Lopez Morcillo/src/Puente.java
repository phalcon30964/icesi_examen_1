
import java.util.concurrent.Semaphore;


public class Puente {

    int numCarros;//contador de carros en un momento dado
    Semaphore mutexNumCarros; //semaforo que impide que varios hilos tomen control de la variable numCarros
    
    Semaphore maxCarros;// El puente es bastante frágil y solo admite el peso de 10 coches simultáneamente.
    
    Semaphore puente;// recurso que representa al puente
    
    Semaphore direccion; // En cualquier momento solo se permite que estén cruzando por el puente coches en un mismo sentido de circulación. 
    
   

    public Puente() {
        numCarros = 0;
        mutexNumCarros = new Semaphore(1, true);
        maxCarros = new Semaphore(10,true); // maximo de carros en un setido dado 
        puente = new Semaphore(1, true);
        direccion = new Semaphore(1, true);
        
    }

    public void subirPuenteDerecha() throws InterruptedException {
        direccion.acquire();// si ya el lector lo esta usando no puede aumentar lectores
        maxCarros.acquire();
        mutexNumCarros.acquire();
        numCarros ++;
         if (numCarros == 1) {
            puente.acquire();
        }
        mutexNumCarros.release();//debe ir adentro el acquire sino, alguien podria aumentar el readers
        direccion.release();
    }

    public void bajarPuenteDerecha() throws InterruptedException {
        mutexNumCarros.acquire();
        numCarros --;
        mutexNumCarros.release();
        if (numCarros == 0) { // Si esta adentro de mutex se da mas importancia al escritor
            puente.release();
            maxCarros.release();
        }
       
    }

    public void subirPuenteIzquierda() throws InterruptedException {
        direccion.acquire();//toma el poder
        maxCarros.acquire();
        mutexNumCarros.acquire();
        numCarros ++;
         if (numCarros == 1) {
            puente.acquire();
        }
        mutexNumCarros.release();//debe ir adentro el acquire sino, alguien podria aumentar el readers
        direccion.release();
    }

    public void bajarPuenteIzquierda() throws InterruptedException {
        mutexNumCarros.acquire();
        numCarros --;
        mutexNumCarros.release();
        if (numCarros == 0) { // Si esta adentro de mutex se da mas importancia al escritor
            puente.release();
            maxCarros.release();
        }
        
        
        
    }
}
