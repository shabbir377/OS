public class ProducerConsumerEg{
    private static final int BUFFER_SIZE = 5;
    private static int counter = 0;
    private static final Object lock = new Object();
    
    public static void main(String[] args){
        int maxIterations = 5;
        producer(maxIterations);
        consumer(maxIterations);
    }
    public static void producer(int maxIterations){
        synchronized (lock){
            for(int i = 0;1 < maxIterations;i++){
                while(counter == BUFFER_SIZE){
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Producer: producing item"+(counter + 1));
                counter++;
                
                if(counter == BUFFER_SIZE){
                    System.out.println("Buffer full, notifying Consumer");
                    lock.notify();
                }
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void consumer(int maxIterations){
        synchronized(lock){
            for (int i = 0; i<maxIterations;i++){
                while (counter==0){
                    try{
                        lock.wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                counter--;
                System.out.println("Consumer: Consuming item"+(counter + 1));
                
                if (counter == 0){
                    System.out.println("Buffer empty");
                    lock.notify();
                }
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}