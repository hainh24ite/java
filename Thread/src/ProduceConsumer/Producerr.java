package ProduceConsumer;

public class Producerr extends Thread {

    Store store = null;
    long index = 1;

    public Producerr(Store s) {
        store = s;
    }

    public void run() {
        while (true) {
            try {
                boolean result = store.put(index);
                if (result == true)
                    System.out.println("*** Sản phẩm " + (index++) + " đã được làm");
                else
                    System.out.println("Đầy rồi ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
