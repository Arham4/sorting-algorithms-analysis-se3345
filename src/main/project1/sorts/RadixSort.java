package project1.sorts;

import project1.ExperimentalResultsData;

import java.util.Arrays;

public final class RadixSort implements Sort<Integer> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, Integer[] list) {
        Integer max = Arrays.stream(list).max(Integer::compareTo).orElse(null);
        if (max == null) {
            return SortType.RADIX_SORT;
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(experimentalResultsData, list, list.length, exp);
        }
        return SortType.RADIX_SORT;
    }

    private void countSort(ExperimentalResultsData experimentalResultsData, Integer[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
            arr[i] = output[i];
        }
    }
}
