
public class ConsoleOutput {

    public void printSearchStart(String searchName) {
        final String START_SEARCH = "Start searching (%s search)...\n";
        System.out.printf(START_SEARCH, searchName);
    }

    public void printSortStart(String sortName) {
        final String START_SEARCH = "Start sorting (%s sort)...\n";
        System.out.printf(START_SEARCH, sortName);
    }

    public void printSortSearchStart(String sortName, String searchName) {
        final String START_SEARCH = "Start searching (%s sort + %s search)...\n";
        System.out.printf(START_SEARCH, sortName, searchName);
//        Start searching (bubble sort + jump search)...
    }

    public void printSearchResultsFoundAndTime(int countFound, int countToFind, long searchMillis) {
        final String OUTPUT = "Found %d/%d entries. Time taken: %d min. %d sec. %d ms.\n";
        long[] minSecMS = convertMStoMinSecMS(searchMillis);
        System.out.printf(OUTPUT, countFound, countToFind, minSecMS[0], minSecMS[1], minSecMS[2]);
    }

    public void printSearchResultTime(long searchMillis) {
        final String OUTPUT = "Searching time: %d min. %d sec. %d ms.\n";
        long[] minSecMS = convertMStoMinSecMS(searchMillis);
        System.out.printf(OUTPUT, minSecMS[0], minSecMS[1], minSecMS[2]);
    }

    public void printSortResultTime(long sortMillis) {
        final String OUTPUT = "Sorting time: %d min. %d sec. %d ms.\n";
        long[] minSecMS = convertMStoMinSecMS(sortMillis);
        System.out.printf(OUTPUT, minSecMS[0], minSecMS[1], minSecMS[2]);
//                Sorting time: 20 min. 12 sec. 251 ms. - STOPPED, moved to linear search
    }

    public void printSortResultTimeError(long sortMillis, String searchName) {
        final String OUTPUT = "Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to %s search\n";
        long[] minSecMS = convertMStoMinSecMS(sortMillis);
        System.out.printf(OUTPUT, minSecMS[0], minSecMS[1], minSecMS[2], searchName);
//                Sorting time: 20 min. 12 sec. 251 ms. - STOPPED, moved to linear search
    }

    private long[] convertMStoMinSecMS(long millis) {
        final long MS_IN_MIN = 60000;
        final long MS_IN_SEC = 1000;
        long[] minSecMS = new long[3];
        minSecMS[0] = millis / MS_IN_MIN; // minutes
        minSecMS[1] = (millis - minSecMS[0] * MS_IN_MIN) / MS_IN_SEC; // seconds
        minSecMS[2] = millis - minSecMS[0] * MS_IN_MIN - minSecMS[1] * MS_IN_SEC; // milliseconds
        return minSecMS;
    }

    public void printCreateHashTime(long searchMillis) {
        final String OUTPUT = "Creating time: %d min. %d sec. %d ms.\n";
        long[] minSecMS = convertMStoMinSecMS(searchMillis);
        System.out.printf(OUTPUT, minSecMS[0], minSecMS[1], minSecMS[2]);
    }

    public void printHashStart() {
        final String START_SEARCH = "Start searching (hash table)...\n";
        System.out.printf(START_SEARCH);
    }
}
