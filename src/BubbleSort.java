
public class BubbleSort extends SortAlgorithm{

    private final String SORT_NAME = "bubble";
    private final long MAX_MILLIS = 10000;
    private boolean valid = true;

    public BubbleSort(String[][] find, String[][] directory) {
//        new ConsoleOutput().printSortStart(SORT_NAME); // TEST
        startMillis = System.currentTimeMillis();
//        sortedFind2DArray = bubbleSort(find); // TEST
        sortedDirectory2DArray = bubbleSort(directory);
        endMillis = System.currentTimeMillis();
        sortMillis = endMillis - startMillis;
//        new ConsoleOutput().printSortResultTime(sortMillis); //TEST
//        print2DArrays(sortedDirectory2DArray); // TEST
    }

    private String[][] bubbleSort(String[][] input) {
        int sortArrayIndex = input[0].length - 1;
//        System.out.println(sortArrayIndex); // TEST
        int sortedIndex = input.length - 1;
//        System.out.println(sortedIndex); // TEST
        long startTimerMillis = System.currentTimeMillis();
        while (sortedIndex > 0) {
            for (int i = 0; i < sortedIndex; i++) {
                int j = i + 1;
//                System.out.println("i: " + input[i][sortArrayIndex] + " j: " + input[j][sortArrayIndex]); // TEST
                if(input[i][sortArrayIndex].compareTo(input[j][sortArrayIndex]) > 0) {
                    swap(input, i, j);
                }
            }
            sortedIndex--;
//            System.out.println(sortedIndex); // TEST
            long currentTime = System.currentTimeMillis() - startTimerMillis;
            if (currentTime >= MAX_MILLIS) {
                valid = false;
                break;
            }
        }
        return input;
    }

    private void swap(String[][] input, int i, int j) {
//        System.out.println("SWAP"); // TEST
        String[] temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private void print2DArrays(String[][] array2D) { // TEST
        for (String[] array : array2D) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid() {
        return valid;
    }
}
