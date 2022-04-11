import java.util.HashMap;

public class HashTable extends SearchAlgorithm{

    long hashCreationMillis, startHashCreationMillis, endHashCreationMillis;

    private String[][] find, directory;
    private HashMap<String, String> directoryHashMap = new HashMap<>();

    public HashTable(String[][] find, String[][] directory) {
        this.find = find;
        this.directory = directory;
        countToFind = find.length;
        startHashCreationMillis = System.currentTimeMillis();
        createHashMap();
        endHashCreationMillis = System.currentTimeMillis();
        hashCreationMillis = endHashCreationMillis - startHashCreationMillis;

        startMillis = System.currentTimeMillis();
        searchHashMap();
        endMillis = System.currentTimeMillis();
        searchMillis = endMillis - startMillis;
    }

    private void createHashMap() {
        for(int i = 0; i < directory.length; i++) {
            directoryHashMap.put(directory[i][2], directory[i][0]);
//            System.out.println(directory[i][2] + " " + directory[i][0]); // TEST
        }
    }

    private void searchHashMap() {
        for(int i = 0; i < find.length; i++) {
            if(directoryHashMap.containsKey(find[i][1])){
                countFound++;
            }
        }
    }

    public long getHashCreationMillis() {
        return hashCreationMillis;
    }
}
