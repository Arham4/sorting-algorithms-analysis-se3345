package project1.gui;

import com.google.inject.Inject;
import project1.data.Student;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

public final class StudentGUIController extends GUIController<Student> {

    @Inject
    public StudentGUIController(InOrderDataGenerator<Student> inOrderDataGenerator, ReverseOrderDataGenerator<Student> reverseOrderDataGenerator, AlmostOrderDataGenerator<Student> almostOrderDataGenerator, RandomOrderDataGenerator<Student> randomOrderDataGenerator) {
        super(inOrderDataGenerator, reverseOrderDataGenerator, almostOrderDataGenerator, randomOrderDataGenerator);
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_SORTS;
    }
}
