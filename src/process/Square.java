package process;

/**
 * clasa care implementeza square
 *
 * @author mihai
 */
public class Square implements Process {

    public Square() {
    }

    /**
     * metoada care calculeaza patratul numarului
     *
     * @param number numar primit
     * @return patratul numarului primit
     */
    public int runProcess(int number) {
        return number * number;
    }
}
