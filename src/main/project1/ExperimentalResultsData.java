package project1;

import project1.sorts.SortType;

public final class ExperimentalResultsData implements Comparable<ExperimentalResultsData> {
    private int comparisons;
    private int movements;
    private int totalTime;
    private SortType lastSort;

    public ExperimentalResultsData() {
        resetData();
    }

    public SortType getLastSort() {
        return lastSort;
    }

    public void setLastSort(SortType lastSort) {
        this.lastSort = lastSort;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public int getMovements() {
        return movements;
    }

    public void setMovements(int movements) {
        this.movements = movements;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void resetData() {
        comparisons = 0;
        movements = 0;
        totalTime = Integer.MAX_VALUE;
        lastSort = null;
    }

    @Override
    public int compareTo(ExperimentalResultsData otherData) {
        int timeComparison = Integer.compare(totalTime, otherData.totalTime);
        if (timeComparison == 0) {
            int comparisonsComparison = Integer.compare(comparisons, otherData.comparisons);
            if (comparisonsComparison == 0) {
                return Integer.compare(movements, otherData.movements);
            }
            return comparisonsComparison;
        }
        return timeComparison;
    }

    public ExperimentalResultsData clone() {
        ExperimentalResultsData clone = new ExperimentalResultsData();
        clone.setMovements(movements);
        clone.setComparisons(comparisons);
        clone.setTotalTime(totalTime);
        clone.setLastSort(lastSort);
        return clone;
    }
}
