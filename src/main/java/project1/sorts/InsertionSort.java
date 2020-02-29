package project1.sorts;

import project1.ExperimentalResultsData;

public final class InsertionSort<E extends Comparable<E>> implements Sort<E> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, E[] list) {
        for (int i = 0; i < list.length; i++) {
            E currentElement = list[i];
            int k;
            experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
            for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                list[k + 1] = list[k];
            }
            if (k + 1 != i) {
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
            }
            list[k + 1] = currentElement;
        }
        return SortType.INSERTION_SORT;
    }
}
