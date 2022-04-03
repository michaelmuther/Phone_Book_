import java.io.File;

public class Main {

    public static void main(String[] args) {

        File find = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/find.txt");
        File directory = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/directory.txt");
        FileInput f = new FileInput(find, directory);
        new ConsoleOutput().printSearchStart("linear");
        LinearSearch a2d = new LinearSearch(f.getFind2DArray(), f.getDirectory2DArray());
        new ConsoleOutput().printSearchResultsFoundAndTime(a2d.getCountFound(), a2d.getCountToFind(), a2d.getSearchMillis() + f.getInputMillis());
        System.out.println();
        new ConsoleOutput().printSortSearchStart("bubble", "jump");
        BubbleSort bs = new BubbleSort(f.getFind2DArray(), f.getDirectory2DArray());
        if (bs.isValid()) {
            JumpSearch js = new JumpSearch(f.getFind2DArray(), f.getDirectory2DArray());
            new ConsoleOutput().printSearchResultsFoundAndTime(js.getCountFound(), js.getCountToFind(), js.getSearchMillis() + bs.getSortMillis());
            new ConsoleOutput().printSortResultTime(bs.getSortMillis());
            new ConsoleOutput().printSearchResultTime(js.getSearchMillis());
        } else {
            LinearSearch a2d2 = new LinearSearch(f.getFind2DArray(), f.getDirectory2DArray());
            new ConsoleOutput().printSearchResultsFoundAndTime(a2d2.getCountFound(), a2d2.getCountToFind(), a2d2.getSearchMillis() + bs.getSortMillis());
            new ConsoleOutput().printSortResultTimeError(bs.getSortMillis(), "linear"); // set this up
            new ConsoleOutput().printSearchResultTime(a2d2.getSearchMillis());
        }
    }
}

