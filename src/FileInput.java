import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {

    private Scanner findS;
    private Scanner directoryS;
    private File find;
    private File directory;
    private ArrayList<String> findList = new ArrayList<>();
    private ArrayList<String> directoryList = new ArrayList<>();

    public FileInput(File find, File directory) {
        this.find = find;
        this.directory = directory;

        try {
            findS = new Scanner(find);
            directoryS = new Scanner(directory);
        }
        catch (Exception e) {
            System.out.println("FileNotFoundException");
        }

        while (findS.hasNext()) {
            findList.add(findS.nextLine());
        }
        while (directoryS.hasNext()) {
            directoryList.add(directoryS.nextLine());
        }
    }

    public ArrayList<String> getFindList() {
        return findList;
    }

    public ArrayList<String> getDirectoryList() {
        return directoryList;
    }
}
