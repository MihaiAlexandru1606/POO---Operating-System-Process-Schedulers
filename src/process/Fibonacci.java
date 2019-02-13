package process;

/**
 * clasa implementeza fibonacci
 * norm valarea pentru care se realizeaza normalizarea
 *
 * @author mihai
 */

public class Fibonacci implements Process {

    public Fibonacci() {
    }

    private final int norm = 9973;

    /**
     * metoda calueaza al number element din sirul lui Fibonacci
     *
     * @param number indexul pentru elemntul din sirul lui Fibonacci
     * @return al number elemntul din sirul lui Fibonacci, normalizat la 9973
     * sau -1 pentru numere negative
     */
    public int runProcess(int number) {
        if (number < 0) return -1;

        if (number == 0) return 0;

        if (number == 1) return 1;

        int fib[] = new int[3];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = -1;

        for (int i = 2; i <= number; i++) {
            fib[2] = fib[1] + fib[0];
            fib[0] = fib[1];
            fib[1] = fib[2];

            fib[0] = fib[0] % norm;
            fib[1] = fib[1] % norm;
            fib[2] = fib[2] % norm;
        }

        return fib[2];
    }
}
