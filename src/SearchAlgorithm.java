
public abstract class SearchAlgorithm {

    long searchMillis, startMillis, endMillis;
    int countToFind, countFound = 0;

    public void printSearchResults() {
        final String OUTPUT_1 = "Found %d/%d entries. Time taken: %d min. %d sec. %d ms.\n";
        final long MS_IN_MIN = 60000;
        final long MS_IN_SEC = 1000;
        long min = searchMillis / MS_IN_MIN;
        long sec = (searchMillis - min * MS_IN_MIN) / MS_IN_SEC;
        long ms = searchMillis - min * MS_IN_MIN - sec * MS_IN_SEC;
        System.out.printf(OUTPUT_1, countFound, countToFind, min, sec, ms);
    }

    public long getSearchMillis() {
        return searchMillis;
    }

    public int getCountToFind() {
        return countToFind;
    }

    public int getCountFound() {
        return countFound;
    }

}
