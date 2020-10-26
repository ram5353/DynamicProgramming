package com.company.KnapSack;

public class SubSetSumWithGivenDiff {
    public static void main(String[] args) {
        int[] values = {1,1,2,3};
        SubSetWithGivenDiff obj = new SubSetWithGivenDiff();
        System.out.println(obj.SubSetSum(values, values.length, obj.GivenDiff(values, values.length, 1)));
    }
}

class SubSetWithGivenDiff {
    public int GivenDiff(int[] values, int n, int diff) {
        int sum = 0;
        for (int i =0; i < n; i++) {
            sum = sum + values[i];
        }
        int key = (diff + sum)/2;
        return key;
    }

    public int SubSetSum(int[] set, int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        int[][] subset = new int[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = 0;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            + subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }
}
