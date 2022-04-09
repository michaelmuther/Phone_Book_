
public class QuickSort extends SortAlgorithm {

    private final String SORT_NAME = "quick";

    public QuickSort (String[][] find, String[][] directory) {
        startMillis = System.currentTimeMillis();
        quickSort(directory, 0, directory.length - 1);
        sortedDirectory2DArray = directory;
        endMillis = System.currentTimeMillis();
        sortMillis = endMillis - startMillis;
    }

    public void quickSort(String[][] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int leftPointer = partition(array, lowIndex, highIndex);
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1,  highIndex);
    }

    private static void swap(String[][] array, int index1, int index2) {
        String[] temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int partition(String[][] array, int lowIndex, int highIndex) {
        String pivot = array[highIndex][2]; // last name is the pivot!
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (array[leftPointer][2].compareTo(pivot) <= 0 && leftPointer < rightPointer) { // change to compares to
                leftPointer++;
            }
            while (array[rightPointer][2].compareTo(pivot) >= 0 && leftPointer < rightPointer) { // change to compares to
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private void print2DArrays(String[][] array2D) { // TEST
        for (String[] array : array2D) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }


}
