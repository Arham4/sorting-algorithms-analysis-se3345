package project1.generator.integer;

import project1.generator.DataGenerator;
import project1.generator.DataType;

import java.util.concurrent.ThreadLocalRandom;

public final class IntegerRandomOrderDataGenerator implements DataGenerator<Integer> {

    private Integer[] list;

    @Override
    public void makeData(int size) {
        list = new Integer[size];
        for (int i = 0; i < list.length; i++) {
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
        return DataType.RANDOM;
    }
}
