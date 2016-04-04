
public class CochesDcha extends Thread {

    Puente puente;
    int id;

    public CochesDcha(Puente database, int readerNumber) {
        this.puente = database;
        this.id = readerNumber;
    }

    public void run() {

        while (true) {

            try {
                puente.entrarDerecha();
            } catch (InterruptedException ex) {
            }

            int tiempoLee = (int) (Math.random() * 3);
            System.out.println("Coche con id " + id + " ENTRA al puente en sentido DERECHO por " + tiempoLee + " segundos");

            try {
                sleep(tiempoLee * 1000);
            } catch (InterruptedException e) {
            }

            try {
                puente.salirDerecha();
            } catch (InterruptedException ex) {
            }

            System.out.println("Coche con id " + id + " SALE del puente en sentido DERECHO");

        }

    }
}
