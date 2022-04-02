import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort extends SortAlgorithm{

    public ArrayListSort (ArrayList<String> input) {
        Collections.sort(input);
        sortedArrayList = input;
    }

}
