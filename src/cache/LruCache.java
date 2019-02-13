package cache;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * LruCahce implementeaza interfata cache, repectand politica "last recently used"
 * @author mihai
 */

public class LruCache implements Cache {

    /**
     * Clasa interna care reprezinta structuara cache-ului
     * atributele clasei:
     * - key: "codificarea" procesului
     * - rezult: rezultatul procesului convertit la string
     * - acess: cand a fost accesata/creata informatia
     *
     * @author mihai
     */
    public class LruStructure {
        private String key;
        private String rezult;
        private int acess;

        public LruStructure() {
            this.key = null;
            this.rezult = null;
            this.acess = 0;
        }

        public LruStructure(String key, String rezult, int acess) {
            this.key = key;
            this.rezult = rezult;
            this.acess = acess;
        }

        /**
         * @return acess
         */
        public int getAcess() {
            return acess;
        }

        /**
         * @param acess valoarea this.acess
         */
        public void setAcess(int acess) {
            this.acess = acess;
        }


    }

    /**
     * clasa interna care implementeaza Comparator, este folosita pt sortare
     *
     * @author mihai
     */
    public class CompareLru implements Comparator<LruStructure> {

        public int compare(LruStructure a, LruStructure b) {

            return a.getAcess() - b.getAcess();

        }
    }

    private int capacity;
    private int size;
    private ArrayList<LruStructure> array;
    private int time;

    public LruCache() {
        this.capacity = 0;
        this.size = 0;
        this.array = null;
        this.time = 0;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new ArrayList<LruStructure>(capacity);
        this.time = 0;
    }

    public String rezult(String code) {
        for (int i = 0; i < this.size; i++) {

            if (code.equals(this.array.get(i).key)) {
                this.time++;
                this.array.get(i).setAcess(this.time);
                return this.array.get(i).rezult;
            }
        }

        return null;
    }

    public void add(String key, String rezult) {
        this.time++;

        if (this.size < this.capacity) {
            LruStructure aux = new LruStructure(key, rezult, this.time);
            this.array.add(aux);
            this.size++;
        } else {
            this.array.sort(new CompareLru());
            LruStructure aux = new LruStructure(key, rezult, this.time);
            this.array.set(0, aux);
        }
    }
}
