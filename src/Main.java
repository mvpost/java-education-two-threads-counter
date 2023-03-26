public class Main {
   public static void main(String[] args) throws InterruptedException {
      CounterThread counterThread = new CounterThread();
      Thread t1 = new Thread(counterThread, "Thread 1");
      Thread t2 = new Thread(counterThread, "Thread 2");
      t1.start();
      t2.start();
      t1.join();
      t2.join();
      CounterObject.decrement();
      System.out.println("Current Value: " + CounterObject.getCounter());
   }
}