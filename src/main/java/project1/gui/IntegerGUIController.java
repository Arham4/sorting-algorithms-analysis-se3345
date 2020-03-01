package project1.gui;

import com.google.inject.Inject;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

public final class IntegerGUIController extends GUIController<Integer> {

    @Inject
    public IntegerGUIController(InOrderDataGenerator<Integer> inOrderDataGenerator, ReverseOrderDataGenerator<Integer> reverseOrderDataGenerator, AlmostOrderDataGenerator<Integer> almostOrderDataGenerator, RandomOrderDataGenerator<Integer> randomOrderDataGenerator) {
        super(inOrderDataGenerator, reverseOrderDataGenerator, almostOrderDataGenerator, randomOrderDataGenerator);
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_AND_INTEGER_SORTS;
    }
}
