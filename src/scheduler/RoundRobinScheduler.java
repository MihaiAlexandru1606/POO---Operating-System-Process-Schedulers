package scheduler;

import io.HomeworkWriter;
import io.ProcessStructure;

/**
 * procesele sunt alese in ordine
 *
 * @author mihai
 */
public class RoundRobinScheduler extends Scheduler {

    public RoundRobinScheduler() {
        super();
    }

    public RoundRobinScheduler(ProcessStructure[] processes, String cacheType, int capacity) {
        super(processes, cacheType, capacity);
    }

    public void run(int[] numbersToBeProcessed, String nameFileOut) {
        HomeworkWriter output = new HomeworkWriter(nameFileOut);

        for (int i = 0; i < numbersToBeProcessed.length; i++) {

            int index = (i % super.getProcesses().length);

            super.proccesRun(index, numbersToBeProcessed[i], output);
        }

        output.close();
    }
}
