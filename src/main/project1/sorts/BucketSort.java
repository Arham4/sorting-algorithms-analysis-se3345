package project1.sorts;

import project1.ExperimentalResultsData;

import java.util.*;

public final class BucketSort implements Sort<Integer> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, Integer[] list) {
        Integer max = Arrays.stream(list).max(Integer::compareTo).orElse(null);
        if (max == null) {
            return SortType.BUCKET_SORT;
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            bucket[i] = 0;
        }
        for (int value : list) {
            bucket[value]++;
        }
        for (int i = 0, j = 0; i <= max; i++) {
            experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
            while (bucket[i] > 0) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
                list[j++] = i;
                bucket[i]--;
            }
        }
        return SortType.BUCKET_SORT;
    }
}
