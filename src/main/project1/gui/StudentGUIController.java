package project1.gui;

import project1.data.Student;
import project1.generator.DataGenerator;
import project1.generator.student.StudentAlmostOrderDataGenerator;
import project1.generator.student.StudentInOrderDataGenerator;
import project1.generator.student.StudentRandomOrderDataGenerator;
import project1.generator.student.StudentReverseOrderDataGenerator;

public final class StudentGUIController extends GUIController<Student> {
    @Override
    protected void initializeListProperties() {
        final DataGenerator<Student> initialDataGenerator = new StudentInOrderDataGenerator();

        dataGenerator = initialDataGenerator;
        inOrderButton.setUserData(initialDataGenerator);
        reverseOrderButton.setUserData(new StudentReverseOrderDataGenerator());
        almostOrderButton.setUserData(new StudentAlmostOrderDataGenerator());
        randomButton.setUserData(new StudentRandomOrderDataGenerator());
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_SORTS;
    }
}
