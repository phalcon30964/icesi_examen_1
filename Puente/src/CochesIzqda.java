
public class CochesIzqda extends Thread {

    Puente puente;
    int id;

    public CochesIzqda(Puente database, int id) {
        this.puente = database;
        this.id = id;
    }

    public void run() {

        while (true) {

            try {
                puente.entrarIzquierda();
            } catch (InterruptedException ex) {
            }

            int tiempoEscribe = (int) (Math.random() * 3);
            
            System.out.println("Coche con id " + id + " ENTRA al puente en sentido IZQUIERDO por " + tiempoEscribe + " segundos");

            try {
                sleep(tiempoEscribe);
            } catch (InterruptedException e) {
            }

            try {
                puente.salirIzquierda();
            } catch (InterruptedException ex) {
            }

            System.out.println("Coche con id " + id + " SALE del puente en sentido IZQUIERDO");
        }
    }
}
