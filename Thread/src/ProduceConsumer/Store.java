package ProduceConsumer;

public class Store {
    int maxN=5;

    long[] a;

    int n;
    public Store(){
        n=0;
        a=new long[maxN];
    }

    private boolean empty(){
        return n==0;
    }

    private boolean full(){
        return n==maxN;
    }

    public synchronized boolean put(long x){
        if(full()){
            return false;
        }
        a[n++]=x;
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return true;
    }

    public synchronized long get(){
        long result=0;
        if(!empty()){
            result=a[0];
            for(int i=1;i<n;i++){
                a[i]=a[i+1];
            }
            n--;
        }
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return result;
    }
}
