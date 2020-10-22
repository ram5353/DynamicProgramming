package com.company.KnapSack;

public class MinSubSetSumDiff {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        int sumTotal = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];
        SubSetDiff obj = new SubSetDiff();
        System.out.println(obj.MinDifference(arr, n, 0, sumTotal));
    }
}

class SubSetDiff {
    public int MinDifference(int[] values, int n, int calculatedSum, int totalSum) {
        if (n == 0) {
            return Math.abs((totalSum - calculatedSum) - calculatedSum);
        }

        return Math.min(MinDifference(values, n-1, calculatedSum + values[n-1],totalSum),
                MinDifference(values, n-1, calculatedSum, totalSum));
    }
}
