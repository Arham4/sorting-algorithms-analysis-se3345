package project1.sorts;

import project1.StringUtilities;

public enum SortType {
    INSERTION_SORT,
    SELECTION_SORT,
    QUICK_SORT,
    MERGE_SORT,
    HEAP_SORT,
    RADIX_SORT,
    BUCKET_SORT,
    ;

    @Override
    public String toString() {
        return StringUtilities.capitalizeWords(name());
    }
}
