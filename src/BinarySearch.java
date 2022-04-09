
public class BinarySearch extends SearchAlgorithm {

    private final String SEARCH_NAME = "binary";

    public BinarySearch (String[][] find, String[][] directory) {
        searchName = SEARCH_NAME;
        countToFind = find.length;
        countFound = 0;
        startMillis = System.currentTimeMillis();
        for (String[] i : find) {
            String findTemp = i[1];
            int lowIndex = 0;
            int highIndex = directory.length - 1;
            while (lowIndex <= highIndex) {
                int midIndex = (lowIndex + highIndex) / 2;
                String guess = directory[midIndex][2];
//                System.out.println("find: " + findTemp + " dir: " + guess); // TEST
                if (guess.equals(findTemp)) {
                    countFound++;
//                    System.out.println(" " + countFound); // TEST
                    break;
                } else if (findTemp.compareTo(guess) < 0) {
                    highIndex = midIndex - 1;
                } else {
                    lowIndex = midIndex + 1;
                }
            }
        }
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
    }
}
