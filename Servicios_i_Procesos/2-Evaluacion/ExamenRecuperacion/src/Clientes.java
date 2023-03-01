public class Clientes extends Thread{
    public Caja caja;
    public Clientes(Caja caja){
        this.caja = new Caja() ;
    }
    public void run() {
        caja.entrarEnCaja(getName());
        
    }
}
