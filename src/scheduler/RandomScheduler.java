package scheduler;

import io.HomeworkWriter;
import io.ProcessStructure;

import java.security.SecureRandom;

/**
 * Procesele sunt alese random
 *
 * @author mihai
 */
public class RandomScheduler extends Scheduler {

    private SecureRandom random;

    public RandomScheduler() {

        super();
        random = null;
    }

    public RandomScheduler(ProcessStructure[] processes, String cacheType, int capacity) {
        super(processes, cacheType, capacity);
        random = new SecureRandom();
    }

    public void run(int[] numbersToBeProcessed, String nameFileOut) {
        HomeworkWriter output = new HomeworkWriter(nameFileOut);

        for (int i = 0; i < numbersToBeProcessed.length; i++) {
            // alegerea procesului random
            int randomIndex = random.nextInt((super.getProcesses().length));

            super.proccesRun(randomIndex, numbersToBeProcessed[i], output);
        }

        output.close();
    }

}
