package project1.generator;

public interface DataGenerator<E extends Comparable<E>> {
    void makeData(int size);
    int getCurrentDataSize();
    E[] getGeneratedDataCopy();
    DataType getDataType();
}
