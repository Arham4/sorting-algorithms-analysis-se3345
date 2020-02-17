package project1.sorts;

import project1.ExperimentalResultsData;

public final class MergeSort<E extends Comparable<E>> implements Sort<E> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, E[] list) {
        if (list.length > 1) {
            E[] firstHalf = (E[]) new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            sort(experimentalResultsData, firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            sort(experimentalResultsData, secondHalf);

            merge(experimentalResultsData, firstHalf, secondHalf, list);
        }
        return SortType.MERGE_SORT;
    }

    private void merge(ExperimentalResultsData experimentalResultsData, E[] list1, E[] list2, E[] temp) {
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
