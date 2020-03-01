package project1.generator.student;

import project1.data.Student;
import project1.data.KhanNameGenerator;
import project1.generator.DataGenerator;
import project1.generator.DataType;

import java.util.concurrent.ThreadLocalRandom;

public final class StudentRandomOrderDataGenerator implements DataGenerator<Student> {

    private Student[] list;

    @Override
    public void makeData(int size) {
        list = new Student[size];
        for (int i = 0; i < list.length; i++) {
            double gpa = ThreadLocalRandom.current().nextDouble(4.0);
            list[i] = new Student(KhanNameGenerator.getRandomName(), gpa);
        }
    }

    @Override
    public int getCurrentDataSize() {
        return list.length;
    }

    @Override
    public Student[] getGeneratedDataCopy() {
        return list.clone();
    }

    @Override
    public DataType getDataType() {
        return DataType.RANDOM;
    }
}
