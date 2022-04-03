import java.util.ArrayList;

public class LinearSearch extends SearchAlgorithm{

    private final String SEARCH_NAME = "linear";

    public LinearSearch(ArrayList<String> find, ArrayList<String> directory) {
//        new ConsoleOutput().printSearchStart(SEARCH_NAME); // TEST
        searchName = SEARCH_NAME + " ArrayList";
        countToFind = find.size();
        countFound = 0;
        startMillis = System.currentTimeMillis();
        for (String f : find) {
            for (String d : directory) {
                if (d.contains(f)) {
                    countFound++;
//                    System.out.println(f + " - " + d); // TEST
                    break;
                }
            }
        }
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
    }

    public LinearSearch(String[][] find2DArray, String[][] directory2DArray) {
//        new ConsoleOutput().printSearchStart(SEARCH_NAME); // TEST
        searchName = SEARCH_NAME + " 2D Array";
        countToFind = find2DArray.length;
        countFound = 0;
        startMillis = System.currentTimeMillis();
        for (int i = 0; i < find2DArray.length; i++) {
            for (int j = 0; j < directory2DArray.length; j++) {
                if (find2DArray[i][1].equals(directory2DArray[j][2]))  {
                    countFound++;
//                    System.out.println(find2DArray[i][1] + " - " + directory2DArray[j][2]); // TEST
                    break;
                }
            }
        }
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
    }
}
