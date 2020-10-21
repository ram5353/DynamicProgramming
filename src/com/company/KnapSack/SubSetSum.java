package com.company.KnapSack;

public class SubSetSum {

    public static void main(String[] args) {
        int[] values = {3, 34, 4, 12, 13, 6};
        SubSet obj = new SubSet();
        System.out.println(obj.findSubSetSumRecursive(values, 9, values.length));
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
}
