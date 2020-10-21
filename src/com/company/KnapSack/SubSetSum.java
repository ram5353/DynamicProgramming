package com.company.KnapSack;

public class SubSetSum {

    public static void main(String[] args) {
        int[] values = {3, 34, 4, 12, 13, 5};
        SubSet obj = new SubSet();
        System.out.println(obj.findSubSetSumRecursive(values, 9, values.length));
        System.out.println(obj.findSubsetSumTopDown(values, values.length, 9));
    }
}

class SubSet {
    public boolean findSubSetSumRecursive(int[] values, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (values[n-1] <= sum) {
            return findSubSetSumRecursive(values, sum - values[n-1], n-1) || findSubSetSumRecursive(values, sum, n-1);
        } else {
            return findSubSetSumRecursive(values, sum, n-1);
        }
    }

    public boolean findSubsetSumTopDown(int set[],
                               int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }
}
