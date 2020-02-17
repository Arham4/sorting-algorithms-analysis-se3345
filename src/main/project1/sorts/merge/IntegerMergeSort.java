package project1.sorts.merge;

import project1.ExperimentalResultsData;
import project1.sorts.IntegerSort;
import project1.sorts.SortType;

public final class IntegerMergeSort implements IntegerSort {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, Integer[] list) {
        if (list.length > 1) {
            Integer[] firstHalf = new Integer[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            sort(experimentalResultsData, firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            Integer[] secondHalf = new Integer[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            sort(experimentalResultsData, secondHalf);

            merge(experimentalResultsData, firstHalf, secondHalf, list);
        }
        return SortType.MERGE_SORT;
    }

    private void merge(ExperimentalResultsData experimentalResultsData, Integer[] list1, Integer[] list2, Integer[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
            if (list1[current1].compareTo(list2[current2]) < 0) {
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);

                temp[current3++] = list1[current1++];
            } else {
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);

                temp[current3++] = list2[current2++];
            }

            while (current1 < list1.length) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
                temp[current3++] = list1[current1++];
            }

            while (current2 < list2.length) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);

                temp[current3++] = list2[current2++];
            }
        }
    }
}
