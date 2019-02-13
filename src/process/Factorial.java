package process;

/**
 * clasa care implementeaza procesul factorial
 *
 * @author mihai
 */
public class Factorial implements Process {

    public Factorial() {
    }

    private final int norm = 9973;

    /**
     * metoda calculeaza numarului modulo 9973
     *
     * @param number numarul primit
     * @return factorial mod 9973 al numarului sau 0 pentru nunmere negative
     */
    public int runProcess(int number) {
        if (number < 0) return 0;

        int factor = 1;
        for (int i = 1; i <= number; i++) {
            factor = factor * (i % norm);
            factor = factor % norm;
        }

        return factor;
    }
}
