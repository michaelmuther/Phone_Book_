import java.util.ArrayList;

public abstract class SortAlgorithm {

    long sortMillis, startMillis, endMillis;
    String sortName;
    String[][] sortedFind2DArray;
    String[][] sortedDirectory2DArray;
    ArrayList<String> sortedFindArrayList;
    ArrayList<String> sortedDirectoryArrayList;
    ArrayList<String> sortedArrayList;

    public long getSortMillis() {
        return sortMillis;
    }

    public String[][] getSortedFind2DArray() {
        return sortedFind2DArray;
    }

    public String[][] getSortedDirectory2DArray() {
        return sortedDirectory2DArray;
    }

    public ArrayList<String> getSortedFindArrayList() {
        return sortedFindArrayList;
    }

    public ArrayList<String> getSortedDirectoryArrayList() {
        return sortedDirectoryArrayList;
    }

    public ArrayList<String> getSortedArrayList() {
        return sortedArrayList;
    }

    public String getSortName() {
        return sortName;
    }

}
