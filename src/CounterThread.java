class CounterThread extends Thread {
    private static int counter;
    private static String winner;

    public CounterThread(String name) {
        super(name);
        counter = 0;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run() {
         while (counter < 100) {
            synchronized (CounterThread.class) {
                counter++;
                if (counter == 100) {
                    winner = getName();
                    System.out.println(winner + ": I'm winner!");
                }
            }
        }
        if (getName() != winner) {
            System.out.println(getName() + ": I'm late...");
        }
    }
}
