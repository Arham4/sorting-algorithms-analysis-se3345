package project1.sorts;

import project1.ExperimentalResultsData;

public final class QuickSort<E extends Comparable<E>> implements Sort<E> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, E[] list) {
        sort(experimentalResultsData, list, 0, list.length - 1);
        return SortType.QUICK_SORT;
    }

    private void sort(ExperimentalResultsData experimentalResultsData, E[] list, int low, int high) {
        int i = low;
        int j = high;

        E pivot = list[low + (high - low) / 2];

        while (i <= j) {
            while (list[i].compareTo(pivot) < 0) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                i++;
            }
            while (list[j].compareTo(pivot) > 0) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                j--;
            }
            if (i <= j) {
                swap(list, i, j);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
                i++;
                j--;
            }
        }

        if (low < j) {
            sort(experimentalResultsData, list, low, j);
        }

        if (i < high) {
            sort(experimentalResultsData, list, i, high);
        }
    }

    private void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
