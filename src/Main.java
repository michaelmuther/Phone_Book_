import java.io.File;

public class Main {

    public static void main(String[] args) {

        File find = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/find.txt");
        File directory = new File("/Users/michaelmuther/Desktop/Phone_Book_/src/directory.txt");
        FileInput f1 = new FileInput(find, directory);
        //-------linear search---------
        new ConsoleOutput().printSearchStart("linear");
        LinearSearch ls1 = new LinearSearch(f1.getFind2DArray(), f1.getDirectory2DArray());
        new ConsoleOutput().printSearchResultsFoundAndTime(ls1.getCountFound(), ls1.getCountToFind(), ls1.getSearchMillis() + f1.getInputMillis());
        System.out.println();
        //-------bubble sort-jump search------
        new ConsoleOutput().printSortSearchStart("bubble", "jump");
        BubbleSort bs = new BubbleSort(f1.getFind2DArray(), f1.getDirectory2DArray());
        if (bs.isValid()) {
            JumpSearch js = new JumpSearch(f1.getFind2DArray(), f1.getDirectory2DArray());
            new ConsoleOutput().printSearchResultsFoundAndTime(js.getCountFound(), js.getCountToFind(), js.getSearchMillis() + bs.getSortMillis());
            new ConsoleOutput().printSortResultTime(bs.getSortMillis());
            new ConsoleOutput().printSearchResultTime(js.getSearchMillis());
        } else {
            LinearSearch ls2 = new LinearSearch(f1.getFind2DArray(), f1.getDirectory2DArray());
            new ConsoleOutput().printSearchResultsFoundAndTime(ls2.getCountFound(), ls2.getCountToFind(), ls2.getSearchMillis() + bs.getSortMillis());
            new ConsoleOutput().printSortResultTimeError(bs.getSortMillis(), "linear"); // set this up
            new ConsoleOutput().printSearchResultTime(ls2.getSearchMillis());
        }
        System.out.println();
        //------quick sort and binary search
        FileInput f2 = new FileInput(find, directory);
        new ConsoleOutput().printSortSearchStart("quick", "binary");
        QuickSort qSort = new QuickSort(f2.getFind2DArray(), f2.getDirectory2DArray());
        BinarySearch bSearch = new BinarySearch(f2.getFind2DArray(), f2.getDirectory2DArray());
        new ConsoleOutput().printSearchResultsFoundAndTime(bSearch.getCountFound(), bSearch.getCountToFind(), bSearch.getSearchMillis() + qSort.getSortMillis() + f2.getInputMillis());
        new ConsoleOutput().printSortResultTime(qSort.getSortMillis() + f2.getInputMillis());
        new ConsoleOutput().printSearchResultTime(bSearch.getSearchMillis());
        System.out.println();
        //----------hash table--------
        new ConsoleOutput().printHashStart();
        HashTable ht = new HashTable(f2.getFind2DArray(), f2.getDirectory2DArray());
        new ConsoleOutput().printSearchResultsFoundAndTime(ht.getCountFound(), ht.getCountToFind(), ht.getHashCreationMillis() + ht.getSearchMillis());
        new ConsoleOutput().printCreateHashTime(ht.getHashCreationMillis());
        new ConsoleOutput().printSearchResultTime(ht.getSearchMillis());
    }
}

//            BinarySearch bSearch = new BinarySearch(f.getFind2DArray(), f.getDirectory2DArray());
//            new ConsoleOutput().printSearchResultsFoundAndTime(bSearch.getCountFound(), bSearch.getCountToFind(), bSearch.getSearchMillis() + bs.getSortMillis());
//            new ConsoleOutput().printSortResultTime(bs.getSortMillis());
//            new ConsoleOutput().printSearchResultTime(bSearch.getSearchMillis());

