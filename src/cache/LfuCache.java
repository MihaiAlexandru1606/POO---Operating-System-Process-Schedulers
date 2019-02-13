package cache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * LfuCahce implementeaza interfata Cache, repectand politica "last frequently used"
 *
 * @author mihai
 */
public class LfuCache implements Cache {

    /**
     * Clasa interna care reprezinta structuara cache-ului
     * atributele clasei:
     * - key: "codificarea" procesului
     * - rezult: rezultatul procesului convertit la string
     * - used: de cate ori este folosita acea informatie
     * - date: data la care a fost creat
     *
     * @author mihai
     */
    public class LfuStructure {
        private String key;
        private String rezult;
        private int used;
        private Date date;

        public LfuStructure() {
            this.key = null;
            this.rezult = null;
            this.used = 0;
            this.date = new Date();
        }

        public LfuStructure(String key, String rezult) {
            this.key = key;
            this.rezult = rezult;
            this.used = 1;
            this.date = new Date();
        }

        /**
         * @return used
         */
        public int getUsed() {
            return used;
        }

        /**
         * @param used valoarea pentru this.used
         */
        public void setUsed(int used) {
            this.used = used;
        }

        /**
         * @return date
         */
        public Date getDate() {
            return date;
        }


    }

    /**
     * clasa interna care implementeaza Comparator, este folosita pt sortare
     *
     * @author mihai
     */
    public class CompareLfu implements Comparator<LfuStructure> {

        public int compare(LfuStructure a, LfuStructure b) {
            if (a.getUsed() == b.getUsed()) {
                return a.getDate().compareTo(b.getDate());
            } else
                return a.getUsed() - b.getUsed();

        }
    }

    private int capacity;
    private int size;
    private ArrayList<LfuStructure> array;

    public LfuCache() {
        this.capacity = 0;
        this.size = 0;
        this.array = null;
    }

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new ArrayList<LfuStructure>(capacity);
    }

    /**
     * metoda cauta key, daca gaseste returneaza rezultatul procesului, altfel null
     */
    public String rezult(String key) {

        for (int i = 0; i < this.size; i++) {

            if (key.equals(this.array.get(i).key)) {
                this.array.get(i).used++; //actualizare numarul de folosiri
                return this.array.get(i).rezult;
            }
        }

        return null;
    }

    /**
     * metoda aduga in cache daca nu este "plin",
     * altfel in locuieste  informatia cea mai putin utilizata
     */
    public void add(String key, String rezult) {

        if (this.size < this.capacity) {
            LfuStructure aux = new LfuStructure(key, rezult);
            this.array.add(aux);
            this.size++;
        } else {
            this.array.sort(new CompareLfu()); // sortarea vectorului
            LfuStructure aux = new LfuStructure(key, rezult);
            this.array.set(0, aux); //inlocuirea informatiei cel mai putin utilizate
        }
    }
}
