

public class JumpSearch extends SearchAlgorithm{

    int step;
    private final String SEARCH_NAME = "jump";

    String[][] find, directory;

    public JumpSearch(String[][] find, String[][] directory) {
        this.find = find;
        this.directory = directory;
        searchName = SEARCH_NAME;
        countToFind = find.length;
        countFound = 0;
        startMillis = System.currentTimeMillis();
        jumpSearch();
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
    }

    private void jumpSearch() {
        step = (int) Math.floor(Math.sqrt(directory.length));
//        System.out.println(step); // TEST
        for (String[] f : find) {
            int current = 0;
            outerloop:
            while (current < directory.length) {
//                System.out.println(f[1] + " - " + directory[current][2]); // TEST
                int tempCompare = f[1].compareTo(directory[current][2]);
                if (tempCompare == 0) {
                    countFound++;
                    break outerloop;
                } else if (tempCompare < 0) { // if find last name is greater than directory last name, then sweep back through;
                    for (int i = current - step + 1; i < current; i++) {
//                        System.out.println("SWEEP: " + f[1] + " - " + directory[i][2]); // TEST
                        if (f[1].compareTo(directory[i][2]) == 0) {
                            countFound++;
                            break outerloop;
                        }
                    }
                } else {
                    current += step; // increase current and try again
                    if (current > directory.length) {
                        for (int i = current - step + 1; i < directory.length; i++) {
//                            System.out.println("SWEEP at END: " + f[1] + " - " + directory[i][2]); // TEST
                            if (f[1].compareTo(directory[i][2]) == 0) {
                                countFound++;
                                break outerloop;
                            }
                        }
                    }
                }
            }
        }
    }
}
