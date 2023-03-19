public class Main {
   public static void main(String[] args) {
      CounterThread thread1 = new CounterThread("Thread 1");
      CounterThread thread2 = new CounterThread("Thread 2");
      thread1.start();
      thread2.start();
      try {
         thread1.join();
         thread2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Counter value: " + CounterThread.getCounter());
   }
}