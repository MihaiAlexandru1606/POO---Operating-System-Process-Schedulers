package process;

/**
 * clasa care implementeaza procesul NextPrime, foloseste CheckPrime
 *
 * @author mihai
 */


public class NextPrime implements Process {

    public NextPrime() {
    }

    /**
     * metoda returneaza cel mai mic numar prim mai mare decat number
     * foloseste clasa CheckPrime
     *
     * @param number numarul pt care se returneaza cel mai mic numar prim mare
     * @return cel mai mic numar prim mai mare decat number
     */
    public int runProcess(int number) {
        if (number < 2) return 2;

        CheckPrime check = new CheckPrime();
        number++; // numarul trebuie sa fie mai care decat cel original
        while (check.runProcess(number) == 0) {
            number++;
        }

        return number;
    }
}
