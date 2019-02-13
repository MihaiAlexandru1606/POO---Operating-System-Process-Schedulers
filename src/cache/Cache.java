package cache;

/**
 * Interfata pentru cache
 * metoda rezult cauta key in cache
 *
 * @author mihai
 */
public interface Cache {

    /**
     * metoda rezult cauta key in cache ,
     * rezultatul procesului este convertit la string
     *
     * @param key codificare pentru un proces,
     * @return rezultatul procesului , daca gaseste key sau null altfel
     */
    public abstract String rezult(String key);

    /**
     * aduaga in cache rezultaul unui proces, in functie de politica cache-ului
     *
     * @param key    "codificarea" pentru un proces
     * @param rezult este rezultatul unui proces convertit la string
     */
    public abstract void add(String key, String rezult);
}
