import io.HomeworkReader;
import io.ProblemData;
import scheduler.RandomScheduler;
import scheduler.RoundRobinScheduler;
import scheduler.Scheduler;
import scheduler.WeightedScheduler;

/**
 * clasa Main, in care se face citirea si rularea planificatorului
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        HomeworkReader input = new HomeworkReader(args[0]);
        ProblemData prob = input.readData();
        Scheduler scheduler = null;

        if (prob.getSchedulerType().equals("RandomScheduler")) {
            scheduler = new RandomScheduler(prob.getProcesses(), prob.getCacheType(), prob.getCacheCapacity());
        } else if (prob.getSchedulerType().equals("RoundRobinScheduler")) {
            scheduler = new RoundRobinScheduler(prob.getProcesses(), prob.getCacheType(), prob.getCacheCapacity());
        } else if (prob.getSchedulerType().equals("WeightedScheduler")) {
            scheduler = new WeightedScheduler(prob.getProcesses(), prob.getCacheType(), prob.getCacheCapacity());
        }

        scheduler.run(prob.getNumbersToBeProcessed(), args[1]);
    }

}
