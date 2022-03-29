import java.util.ArrayList;

public class SearchAlgorithm {

    public SearchAlgorithm(ArrayList<String> find, ArrayList<String> directory) {
        final String OUTPUT_1 = "Found %d/%d entries. Time taken: %d min. %d sec. %d ms.\n";
        final String START = "Start searching...";
        final long MS_IN_MIN = 60000;
        final long MS_IN_SEC = 1000;
        int countToFind = find.size();
        int countFound = 0;
        System.out.println(START);
        long startMillis = System.currentTimeMillis();

        for (String f : find) {
            for (String d : directory) {
                if (d.contains(f)) {
                    countFound++;
                    System.out.println("f: " + f + " d: " + d);
                    break;
                }
            }
        }

        long endMillis = System.currentTimeMillis();
        long searchMillis = endMillis - startMillis;
        long min = searchMillis / MS_IN_MIN;
        long sec = (searchMillis - min * MS_IN_MIN) / MS_IN_SEC;
        long ms = searchMillis - min * MS_IN_MIN - sec * MS_IN_SEC;
        System.out.printf(OUTPUT_1, countFound, countToFind, min, sec, ms);
    }
}
