package backtracking;

public abstract class Backtrack {
    
    protected boolean finished;
    protected int ncandidates;
    protected int MAX_CANDIDATES;

    public Backtrack(int MAX_CANDIDATES) {
        finished = false;
        this.MAX_CANDIDATES = MAX_CANDIDATES;
    }

    protected void backtrack(int a[], int k, int input) {
        int[] candidates = new int[MAX_CANDIDATES];

        if (isASolution(a, k, input)) {
            processSolution(a, k, input);
        } else {
            k = k + 1;
            constructCandidates(a, k, input, candidates);
            for (int i = 0; i < ncandidates; i++) {
                a[k] = candidates[i];
                makeMove(a, k, input);
                backtrack(a, k, input);
                unmakeMove(a, k, input);
                if (finished) return;
            }
        }
    }

    protected abstract boolean isASolution(int[] a, int k, int input);

    protected abstract void processSolution(int[] a, int k, int input);

    protected abstract void constructCandidates(int[] a, int k, int input, int[] candidates);

    protected abstract void makeMove(int[] a, int k, int input);

    protected abstract void unmakeMove(int[] a, int k, int input);
}




