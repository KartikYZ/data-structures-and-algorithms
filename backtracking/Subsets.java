package backtracking;

public class Subsets extends Backtrack {

    public static void main(String[] args) {

        int[] a = new int[20];
        Subsets generateSubsets = new Subsets(10);
        generateSubsets.backtrack(a, 0, 4);
    }

    Subsets(int MAX_CANDIDATES) {
        super(MAX_CANDIDATES);
    }
    
    protected boolean isASolution(int[] a, int k, int n) {
        return k == n;
    }

    protected void processSolution(int[] a, int k, int n) {
        StringBuilder sb = new StringBuilder().append('{');
        for (int i = 1; i <= k; i++) {
            if (a[i] == 1) { 
                sb.append(Integer.toString(i)); 
                sb.append(" ");
            }
            
        }
        sb.append('}');
        System.out.println(sb.toString());
    }

    protected void constructCandidates(int[] a, int k, int n, int[] candidates) {
        candidates[0] = 1;
        candidates[1] = 0;
        ncandidates = 2;
    }

    protected void makeMove(int[] a, int k, int input) {

    }

    protected void unmakeMove(int[] a, int k, int input) {

    }
}