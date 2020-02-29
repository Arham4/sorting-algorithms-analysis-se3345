package project1.generator.integer;

import project1.generator.DataType;
import project1.generator.InOrderDataGenerator;

public final class IntegerInOrderDataGenerator implements InOrderDataGenerator<Integer> {

    private Integer[] list;

    @Override
    public void makeData(int size) {
        list = new Integer[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
    }

    @Override
    public int getCurrentDataSize() {
        return list.length;
    }

    @Override
    public Integer[] getGeneratedDataCopy() {
        return list.clone();
    }

    @Override
    public DataType getDataType() {
        return DataType.IN_ORDER;
    }
}
