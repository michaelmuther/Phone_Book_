import java.util.ArrayList;

public class LinearSearch extends SearchAlgorithm{

    public LinearSearch(ArrayList<String> find, ArrayList<String> directory) {
        final String START = "Start searching (linear search)...";
        countToFind = find.size();
        countFound = 0;
        System.out.println(START);
        startMillis = System.currentTimeMillis();
        for (String f : find) {
            for (String d : directory) {
                if (d.contains(f)) {
                    countFound++;
                    break;
                }
            }
        }
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
        printSearchResults();
    }
}
