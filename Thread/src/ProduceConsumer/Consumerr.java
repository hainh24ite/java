package ProduceConsumer;

public class Consumerr extends Thread {

    Store store = null;

    public Consumerr(Store s) {
        store = s;
    }

    public void run() {
        while (true) {
            try {
                long x = store.get();
                if (x > 0)
                    System.out.println("-- sản phẩm " + x + " đã được mua");
                else
                    System.out.println("Hết sản phẩm");
            } catch (Exception e) {
            }
        }
    }
}
