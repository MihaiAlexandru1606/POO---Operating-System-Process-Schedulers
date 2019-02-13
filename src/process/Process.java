package process;

/**
 * Interfata pentru fiecare proces.
 * Clasele care implementeza interfata trebuie sa implementeza metoda runProcess
 *
 * @author mihai
 */
public interface Process {

    /**
     * metoda abstrcata care descrie comportamentul fiecarul "proces"
     * fiecare "proces" trebuie sa primeasca un int si returneza int
     *
     * @param number parametru primit
     * @return rezultatul "procesului" pentru number
     */
    public abstract int runProcess(int number);

}
