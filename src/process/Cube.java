package process;

/**
 * clasa care implementeaza procesul Cube
 *
 * @author mihai
 */
public class Cube implements Process {

    public Cube() {
    }

    /**
     * metoda care claculeaza cubul numarului
     *
     * @param number numarul primit
     * @return numarul la puterea a 3
     */
    public int runProcess(int number) {
        return (int) Math.pow(number, 3);
    }
}
