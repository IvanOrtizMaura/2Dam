public class Cajeros extends Thread {
    public Caja caja;

    public Cajeros(Caja caja) {
        this.caja = new Caja();
    }

    public void run() {
        while(!this.isInterrupted()){
            System.out.println("intento atender");
            caja.atender();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
}
