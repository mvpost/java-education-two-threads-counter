class CounterObject {
    private static Integer counter = 0;
    public static Integer getCounter() {
        return counter;
    }
    public static Integer increment() {
        synchronized(CounterObject.class) {
            counter++;
            return counter;
        }
    }

    public static void decrement() {
        counter--;
    }
}
