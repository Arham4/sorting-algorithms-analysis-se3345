package project1.sorts;

import project1.ExperimentalResultsData;

public interface Sort<E extends Comparable<E>> {
    SortType sort(ExperimentalResultsData experimentalResultsData, E[] list);
}
