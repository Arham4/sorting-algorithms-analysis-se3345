package project1.gui;

import project1.data.Student;

public final class StudentGUIController extends GUIController<Student> {
    public StudentGUIController() {
        super(Student.class);
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_SORTS;
    }
}
