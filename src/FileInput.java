import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {

    private Scanner findSCount;
    private Scanner directorySCount;
    private Scanner findSArrayList;
    private Scanner directorySArrayList;
    private Scanner findS2DArray;
    private Scanner directoryS2DArray;
    private ArrayList<String> findArrayList = new ArrayList<>();
    private ArrayList<String> directoryArrayList = new ArrayList<>();
    private String[][] find2DArray;
    private String[][] directory2DArray;
    private int directoryLineCount = 0;
    private int findLineCount = 0;
    private long inputMillis;

    public FileInput(File find, File directory) {
        long startMillis = System.currentTimeMillis();
        try {
            findSCount = new Scanner(find);
            directorySCount = new Scanner(directory);
            findSArrayList = new Scanner(find);
            directorySArrayList = new Scanner(directory);
            findS2DArray = new Scanner(find);
            directoryS2DArray = new Scanner(directory);
        }
        catch (Exception e) {
            System.out.println("FileNotFoundException");
        }
        countLines();
        createArrayLists();
        create2DArrays();
//        print2DArrays(find2DArray); // TEST
//        print2DArrays(directory2DArray); // TEST
        long endMillis = System.currentTimeMillis();
        inputMillis = endMillis - startMillis;
    }

    private void countLines() {
        while (findSCount.hasNext()) {
            findSCount.nextLine();
            findLineCount++;
        }
        while (directorySCount.hasNext()) {
            directorySCount.nextLine();
            directoryLineCount++;
        }
//        System.out.println("findLineCount: " + findLineCount); // TEST
//        System.out.println("directoryLineCount " + directoryLineCount); // TEST
    }

    private void createArrayLists() {
        while (findSArrayList.hasNext()) {
            findArrayList.add(findSArrayList.nextLine());
        }
        while (directorySArrayList.hasNext()) {
            directoryArrayList.add(directorySArrayList.nextLine());
        }
    }

    private void create2DArrays() {
        find2DArray = new String[findLineCount][2]; // first and last name; sometimes just a last name
        directory2DArray = new String[directoryLineCount][3]; // number, first and last name, sometimes just a last name
        int findLineIndex = 0;
        while (findS2DArray.hasNext()) {
//            System.out.println(findS2DArray.nextLine()); // TEST
            String[] temp1 = findS2DArray.nextLine().split(" "); // "\\s+"
            if (temp1.length == 1) {
                find2DArray[findLineIndex][0] = "******";
                find2DArray[findLineIndex][1] = temp1[0]; // if there is only one name, it is a last name
            } else {
                find2DArray[findLineIndex][0] = temp1[0];
                find2DArray[findLineIndex][1] = temp1[1];
            }
            findLineIndex++;
        }
        int directoryLineIndex = 0;
        while (directoryS2DArray.hasNext()) {
            String[] temp2 = directoryS2DArray.nextLine().split("\\s+");
            if (temp2.length == 2) {
                directory2DArray[directoryLineIndex][0] = temp2[0];
                directory2DArray[directoryLineIndex][1] = "******";
                directory2DArray[directoryLineIndex][2] = temp2[1]; // if there is only one name, it is a last name
            } else {
                directory2DArray[directoryLineIndex][0] = temp2[0];
                directory2DArray[directoryLineIndex][1] = temp2[1];
                directory2DArray[directoryLineIndex][2] = temp2[2];
            }
            directoryLineIndex++;
        }
    }

    private void print2DArrays(String[][] array2D) { // TEST
        for (String[] array : array2D) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> getFindArrayList() {
        return findArrayList;
    }

    public ArrayList<String> getDirectoryArrayList() {
        return directoryArrayList;
    }

    public String[][] getFind2DArray() {
        return find2DArray;
    }

    public String[][] getDirectory2DArray() {
        return directory2DArray;
    }

    public long getInputMillis() {
        return inputMillis;
    }
}
