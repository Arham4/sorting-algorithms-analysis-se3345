package project1.sorts.heap;

import project1.ExperimentalResultsData;
import project1.sorts.Sort;
import project1.sorts.SortType;

public final class HeapSort<E extends Comparable<E>> implements Sort<E> {
    @Override
    public SortType sort(ExperimentalResultsData experimentalResultsData, E[] list) {
        Heap<E> heap = new Heap<>(experimentalResultsData, list);
        for (int i = list.length - 1; i >= 0; i--) {
            experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 1);
            list[i] = heap.remove();
        }
        return SortType.HEAP_SORT;
    }
}
