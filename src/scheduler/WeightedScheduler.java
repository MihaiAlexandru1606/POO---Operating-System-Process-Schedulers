package scheduler;

import io.HomeworkWriter;
import io.ProcessStructure;

/**
 * procesele sunt alese astfel incat sa se pastreze reaportul cotelor pentru fiecare proces
 *
 * @author mihai
 */

public class WeightedScheduler extends Scheduler {

    private int weight[];
    private int total;

    public WeightedScheduler() {
    }

    public WeightedScheduler(ProcessStructure[] processes, String cacheType, int capacity) {
        super(processes, cacheType, capacity);
        this.weight = new int[processes.length];

        int gcd = gcdWeight(processes);
        for (int i = 0; i < this.weight.length; i++) {
            this.weight[i] = processes[i].getWeight() / gcd;
        }

        this.total = this.sum();
    }

    /**
     * metoda caulculeaza gcd pentru doua numere
     *
     * @param a primul numar
     * @param b al doilea numer
     * @return cmmdc al lui a si b
     */
    private int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    /**
     * metoda calculeaza cmmdc pentru un vectorul de cote
     *
     * @return cmmdc pentru "vectorul" de cote
     */
    private int gcdWeight(ProcessStructure[] processes) {
        if (processes.length == 1) return processes[0].getWeight();

        if (processes.length == 2) {
            return gcd(processes[0].getWeight(), processes[1].getWeight());
        }

        int gcd = gcd(processes[0].getWeight(), processes[1].getWeight());
        for (int i = 2; i < processes.length; i++) {
            gcd = gcd(gcd, processes[i].getWeight());
        }

        return gcd;
    }

    public void run(int[] numbersToBeProcessed, String nameFileOut) {

        HomeworkWriter output = new HomeworkWriter(nameFileOut);


        for (int i = 0; i < numbersToBeProcessed.length; i++) {
            // alegerea procesului pentru a respecta politica planificatorului
            int index = this.indexWeightedScheduler(i % this.total);

            super.proccesRun(index, numbersToBeProcessed[i], output);
        }

        output.close();
    }

    /**
     * metoada calculaeaza suma cotelor
     *
     * @return suma cotelor
     */
    private int sum() {
        int sum = 0;

        for (int i = 0; i < this.weight.length; i++)
            sum = sum + this.weight[i];

        return sum;
    }

    /**
     * metoda returneaza indexul procesului ce trebuie rula,
     * un proces cu indexul i trebuei rulat daca (order - sum(i-1)) < weight[i]
     * unde sum(i - 1) este suma coteor pana la indexul i, sum(0) este 0
     *
     * @param order un numar de la 0 la this.total - 1
     * @return indecele procesului ce trebuie rulat
     */
    private int indexWeightedScheduler(int order) {
        int i;

        for (i = 0; i < this.weight.length; i++) {
            if (order < this.weight[i]) {
                break;
            } else {
                order = order - this.weight[i];
            }
        }

        return i;
    }
}
