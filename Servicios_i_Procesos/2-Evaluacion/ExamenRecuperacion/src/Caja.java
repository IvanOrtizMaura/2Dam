import java.util.LinkedList;

public class Caja {
    LinkedList<String> caja;

    public Caja() {
        this.caja = new LinkedList<>();
    }

    public synchronized void entrarEnCaja(String nombre) {
        System.out.println("Soy el cliente: " + nombre + " y voy a entrar a la caja");
        try {
            System.out.println(caja);
            caja.add(nombre);
            System.out.println(caja);
            while (!(caja.peek().equals(nombre))) {
                System.out.println("Soy el cliente: " + nombre + "y estoy esperando");
                // El cliente espera
                wait();
            }

            System.out.println("Soy el cliente: " + nombre + " ya he entrado a la caja");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    public synchronized void atender() {
        try {
            System.out.println(caja);
            if (caja.size() > 0) {
                // Avisamos a todos los clientes, pero tiene que entrar el primero
                System.out.println("Soy el cajero: Estoy atendiendo a " + caja.remove());
                notifyAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

}
