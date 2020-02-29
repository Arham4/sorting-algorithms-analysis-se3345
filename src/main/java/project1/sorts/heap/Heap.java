package project1.sorts.heap;

import project1.ExperimentalResultsData;

import java.util.ArrayList;
import java.util.List;

public final class Heap<E extends Comparable<E>> {
    private final ExperimentalResultsData experimentalResultsData;
    private List<E> list = new ArrayList<>();

    public Heap(ExperimentalResultsData experimentalResultsData) {
        this.experimentalResultsData = experimentalResultsData;
    }

    public Heap(ExperimentalResultsData experimentalResultsData, E[] objects) {
        this.experimentalResultsData = experimentalResultsData;
        for (E object : objects) {
            add(object);
        }
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 2);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (list.size() == 0) {
            return null;
        }

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) {
                break;
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            experimentalResultsData.setComparisons(experimentalResultsData.getComparisons() + 1);
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                experimentalResultsData.setMovements(experimentalResultsData.getMovements() + 2);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }
}
