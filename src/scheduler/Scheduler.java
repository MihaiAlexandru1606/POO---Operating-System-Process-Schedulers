package scheduler;

import cache.Cache;
import cache.LfuCache;
import cache.LruCache;
import cache.NoCache;
import io.HomeworkWriter;
import io.ProcessStructure;
import process.*;
import process.Process;

public abstract class Scheduler {

    private ProcessStructure[] processes;
    private Cache cache;
    private Process process;

    public Scheduler() {
        this.cache = null;
        this.process = null;
        this.process = null;
    }

    public Scheduler(ProcessStructure[] processes, String cacheType, int capacity) {
        this.cache = this.typeChache(cacheType, capacity);
        this.processes = processes;
        this.process = null;
    }

    public ProcessStructure[] getProcesses() {
        return processes;
    }

    public void setProcesses(ProcessStructure[] processes) {
        this.processes = processes;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Cache typeChache(String nameCache, int capacity) {
        if (nameCache.equals("NoCache")) {
            return new NoCache();
        }

        if (nameCache.equals("LfuCache")) {
            return new LfuCache(capacity);
        }

        if (nameCache.equals("LruCache")) {
            return new LruCache(capacity);
        }

        return null;// nu se intampla in program
    }

    public Process typeProcess(String nameProcess) {
        if (nameProcess.equals("CheckPrime"))
            return new CheckPrime();

        if (nameProcess.equals("NextPrime"))
            return new NextPrime();

        if (nameProcess.equals("Fibonacci"))
            return new Fibonacci();

        if (nameProcess.equals("Sqrt"))
            return new Sqrt();

        if (nameProcess.equals("Square"))
            return new Square();

        if (nameProcess.equals("Cube"))
            return new Cube();

        if (nameProcess.equals("Factorial"))
            return new Factorial();

        return null; // nu se intampla in program

    }

    protected void proccesRun(int indexProcces, int number, HomeworkWriter output) {
        String nameProcessRun = processes[indexProcces].getType();
        String key = nameProcessRun + number;

        // cautarea prin cache daca prcesul a fost calculat
        String rezult = cache.rezult(key);

        if (rezult != null) {
            output.println(number + " " + nameProcessRun + " " + rezult + " FromCache");
        } else {
            process = typeProcess(nameProcessRun);

            //rezultatul prcesului executat
            int calduledRezult = process.runProcess(number);
            output.println(number + " " + nameProcessRun + " " + calduledRezult + " Computed");
            //aduagera in cache a rezulatului procesului
            cache.add(key, String.valueOf(calduledRezult));
        }
    }

    /**
     * metoda ruleaza procesele in  functe de politica fiecarui planificator
     *
     * @param numbersToBeProcessed numerele sunt argumente pentru procese
     * @param nameFileOut          numele fisierului de scriere
     */
    public abstract void run(int[] numbersToBeProcessed, String nameFileOut);
}
