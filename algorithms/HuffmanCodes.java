package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class HuffmanCodes {

    public static TreeMap<Character, Integer> huffmanTree(String s) {
        // TODO:
        return null;
    }
    
    public static Map<Character, Integer> characterFrequencyMap(String s) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = charFreqMap.getOrDefault(c, 0);
            charFreqMap.put(c, freq + 1);
        }
        return charFreqMap;
    }

    public static void main(String[] args) {
        String testWord = "Hello World";
        System.out.println(characterFrequencyMap(testWord));
    }
}
