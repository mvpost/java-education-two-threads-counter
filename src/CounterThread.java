class CounterThread implements Runnable {
    private static final Object lock = new Object();
    public void run() {
        while (CounterObject.getCounter() <= 100) {

            Integer increment = CounterObject.increment();
            synchronized(lock) {
                if (increment == 100)
                {
                    try {
                        lock.wait();
                    }
                    catch (InterruptedException e) {}
                    System.out.println(Thread.currentThread().getName() + ": I'm winner!");
                }
                if (increment > 100)
                {
                    System.out.println(Thread.currentThread().getName() + ": I'm late....");
                    lock.notify();
                }
            }
        }
    }
}