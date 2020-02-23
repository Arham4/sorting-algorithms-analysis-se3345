package project1.generator.student;

import project1.data.Student;
import project1.data.KhanNameGenerator;
import project1.generator.DataType;

public final class StudentInOrderDataGenerator implements StudentDataGenerator {

    private Student[] list;

    @Override
    public void makeData(int size) {
        list = new Student[size];
        for (int i = 0; i < list.length; i++) {
            double incrementation = 4.0 / size;
            double gpa = incrementation * (i + 1);
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
        return DataType.IN_ORDER;
    }
}
