package project1.generator.student;

import project1.data.Student;
import project1.data.StudentRandomNameGenerator;
import project1.generator.DataType;

import java.util.concurrent.ThreadLocalRandom;

public final class StudentAlmostOrderDataGenerator implements StudentDataGenerator {
    private Student[] list;

    @Override
    public void makeData(int size) {
        list = new Student[size];
        int endIndex = (int) (list.length * (2.0 / 3));
        for (int i = 0; i < endIndex; i++) {
            double incrementation = 4.0 / size;
            double gpa = incrementation * (i + 1);
            list[i] = new Student(StudentRandomNameGenerator.getRandomName(), gpa);
        }
        for (int i = endIndex; i < list.length; i++) {
            double gpa = ThreadLocalRandom.current().nextDouble(4.0);
            list[i] = new Student(StudentRandomNameGenerator.getRandomName(), gpa);
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
        return DataType.ALMOST_ORDER;
    }
}
