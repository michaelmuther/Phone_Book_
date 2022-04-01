import java.util.ArrayList;

public class JumpSearch extends SearchAlgorithm{

    int step;
    ArrayList<String> find, directory;

    public JumpSearch(ArrayList<String> find, ArrayList<String> directory) {
        final String START = "Start searching (jump search)...";
        this.find = find;
        this.directory = directory;
        countToFind = find.size();
        countFound = 0;
        System.out.println(START);
        startMillis = System.currentTimeMillis();
        jumpSearch();
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
        printSearchResults();
    }

    private void jumpSearch() {
        step = (int) Math.floor(Math.sqrt(directory.size()));
//        System.out.println(step);

        for (String f : find) {
            int curr = 0;
            while (curr < directory.size()) {
                if (directory.get(curr).contains(f)) {
                    countFound++;
                    break;
                }
            }
        }
    }

}
