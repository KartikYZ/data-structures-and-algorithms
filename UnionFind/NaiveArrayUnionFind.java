package UnionFind;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

/**
 * An inefficient naive implementation of the union-find data structure.
 */
public class NaiveArrayUnionFind<T> {

    List<T> set;
    int[] uf;
    HashMap<T, Integer> map;

    // initialize all elements as singletons
    public NaiveArrayUnionFind(List<T> set) {
        this.set = set;
        
        this.uf = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            uf[i] = i;
        }
    }

    // O(1) find operations by array lookup
    public T find(T item) {
        if (!map.containsKey(item)) { return null; }
        return set.get(uf[map.get(item)]);
    }

    // O(n) as entire array must be traversed
    public void union(T a, T b) {
        int repA = map.get(find(a));
        int repB = map.get(find(b));
        for (int i = 0; i < uf.length; i++) {
            if (uf[i] == repB) {
                uf[i] = repA;
            }
        }
    }

    // returns indices for labels, which are elements themselves, corresponding to each element
    public String toString() {
        return Arrays.toString(uf);
    }
}
