package union_find;

import java.util.List;
import java.util.ArrayList;

public class UnionFindDriver {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(7);
        arr.add(8);
        arr.add(1);
        System.out.println(arr);
        NaiveArrayUnionFind<Integer> nauf = new NaiveArrayUnionFind<>(arr);
        System.out.println(nauf);
        nauf.union(2, 1);
        System.out.println(nauf);
        nauf.union(7, 8);
        System.out.println(nauf);
        nauf.union(4, 1);
        System.out.println(nauf);
        nauf.union(1, 8);
        System.out.println(nauf);
    }
}
