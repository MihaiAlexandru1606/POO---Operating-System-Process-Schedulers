package cache;

/**
 * clasa NoCache implemnteaza metodele interfetei cache
 * metoda rezult returneaza mereu null
 * metoda add nu face "nimic"
 *
 * @author mihai
 */
public class NoCache implements Cache {

    public NoCache() {
    }

    public String rezult(String code) {
        return null;
    }

    public void add(String key, String rezult) {
    }
}
