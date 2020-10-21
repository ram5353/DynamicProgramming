package com.company.KnapSack;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] values = {1, 5, 11, 5};
        EqualSum obj = new EqualSum();
        System.out.println(obj.EqualPartition(values));
    }
}

class EqualSum {

    public int sum = 0;
    public boolean EqualPartition(int[] values) {
        for (int i =0; i< values.length; i++) {
            sum = sum + values[i];
        }
        if (sum%2 != 0) {
            return false;
        } else {
            return SubSetSum(values, sum/2, values.length);
        }
    }

    public boolean SubSetSum(int[] values, int sum, int n) {
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (values[n-1] <= sum) {
            return SubSetSum(values, sum - values[n-1], n-1) || SubSetSum(values, sum, n-1);
        } else {
            return SubSetSum(values, sum, n-1);
        }
    }
}
