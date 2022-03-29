import java.io.File;

public class Main {

    public static void main(String[] args) {

        File find = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/small_find.txt");
        File directory = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/directory.txt");
        FileInput f = new FileInput(find, directory);
        new SearchAlgorithm(f.getFindList(), f.getDirectoryList());
    }
}

