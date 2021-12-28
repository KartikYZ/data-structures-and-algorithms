package tries;

import java.util.List;

import java.util.ArrayList;

public class WordGrid {

    int m;
    int n;
    boolean[][] visited;
    char[][] grid;
    
    
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("DOG");
        words.add("DOGA");
        words.add("DOGE");
        words.add("BAR");
        words.add("STAR");
        words.add("BACH");

        char[][] grid = {
            { 'E', 'D', 'B' },
            { 'R', 'O', 'A' },
            { 'E', 'G', 'R' },
            { 'K', 'A', 'L' },
        };
        WordGrid wGrid = new WordGrid();
        List<String> found = wGrid.WordsInGrid(grid, words);
        System.out.println(found);
    }

    public List<String> WordsInGrid(char[][] grid, List<String> words) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        Trie trie = constructTrie(words);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                dfs(i, j, trie.root.children[grid[i][j] - 65]);
            }
        }

        return trie.traverse();
    }

    public void dfs(int i, int j, TrieNode node) {
        if (node == null) {
            return;
        } 

        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }

        if (node.isWord) {
            node.isReachable = true;
        }
        
        visited[i][j] = true;

        dfs(i + 1, j, node.children[grid[i + 1][j] - 65]);
        dfs(i - 1, j, node.children[grid[i - 1][j] - 65]);
        dfs(i, j + 1, node.children[grid[i][j + 1] - 65]);
        dfs(i, j - 1, node.children[grid[i][j - 1] - 65]);
    }

    private Trie constructTrie(List<String> words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.add(word);
        }
        return trie;
    }
}

class Trie {
    TrieNode root;
    List<String> found;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 65;
            if (current.children[c] == null) {
                current.children[c] = new TrieNode();
            } 
            current.count++;
            current = current.children[c];
        }
        current.isWord = true;
        current.count++;
    }

    public List<String> traverse() {
        found = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        reachableWords(root, temp);
        System.out.println(found);
        return found;
    }

    public void reachableWords(TrieNode current, List<Character> temp) {
        for (int i = 0; i < 26; i++) {
            TrieNode next = current.children[i];
            if (next == null) {
                continue;
            }
            if (next.isWord && next.isReachable) {
                String word = "";
                for (char a : temp) {
                    word += a;
                }
                found.add(word);
                temp.clear();
                next.count--;
            } 
            if (next.count > 0) {
                char c = (char) (i + 65);
                temp.add(c);
                reachableWords(next, temp);
            }
        }
    }
}

class TrieNode {
    TrieNode[] children;
    int count; 
    boolean isWord;
    boolean isReachable;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
