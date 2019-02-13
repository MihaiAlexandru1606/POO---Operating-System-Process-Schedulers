package process;


public class CheckPrime implements Process {

    public CheckPrime() {
    }

    public int runProcess(int number) {
        if (number < 2)
            return 0;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return 0;
        }

        return 1;
    }

}
