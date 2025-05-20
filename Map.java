import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    public static ArrayList<ArrayList<Integer>> getMap() {
        ArrayList<ArrayList<Integer>> test_array_2 = new ArrayList<>();
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 0, 1, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0, 1, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0, 1, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1 )));
        return test_array_2;
    }
}