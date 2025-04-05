package ProduceConsumer;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producerr producer = new Producerr(store);
        Consumerr consumer = new Consumerr(store);

        producer.start();
        consumer.start();
    }
}
