public class Main {

    public static void main(String[] args) {

        final String horses_id = "ABC";
        final int horses_qty = horses_id.length();

        Horse[] horses = new Horse[horses_qty];
        Thread[] threads = new Thread[horses_qty];

        for (int i = 0; i < horses_qty; i++) {
            horses[i] = new Horse();
            threads[i] = new Thread(horses[i], "horse{" + horses_id.substring(i, i + 1) + "}");
        }

        // Largada!
        for (Thread t: threads)
          t.start();

    }

}
