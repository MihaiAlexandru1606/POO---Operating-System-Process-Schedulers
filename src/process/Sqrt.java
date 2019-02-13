package process;

/**
 * clasa care impleneteaza procesul sqrt
 *
 * @author mihai
 */
public class Sqrt implements Process {

    public Sqrt() {
    }

    /**
     * functia calculeaza redicalul moduluilui numarului
     *
     * @param number numarul pentru care se caluleaza redicalul
     * @return partea intreaga a radicalului modulului numarlui primit
     */
    public int runProcess(int number) {
        return (int) Math.floor(Math.sqrt(Math.abs(number)));
    }
}
