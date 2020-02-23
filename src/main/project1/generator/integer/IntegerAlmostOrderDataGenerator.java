package project1.generator.integer;

import project1.generator.DataType;

import java.util.concurrent.ThreadLocalRandom;

public final class IntegerAlmostOrderDataGenerator implements IntegerDataGenerator {
    private Integer[] list;

    @Override
    public void makeData(int size) {
        list = new Integer[size];
        int endIndex = (int) (list.length * (2.0 / 3));
        for (int i = 0; i < endIndex; i++) {
            list[i] = i + 1;
        }
        for (int i = endIndex; i < list.length; i++) {
            list[i] = ThreadLocalRandom.current().nextInt(0, size);
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
        return DataType.ALMOST_ORDER;
    }
}
