package project1.sorts;

import project1.ExperimentalResultsData;

public final class SelectionSort<E extends Comparable<E>> implements Sort<E> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            E currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return SortType.SELECTION_SORT;
    }
}
