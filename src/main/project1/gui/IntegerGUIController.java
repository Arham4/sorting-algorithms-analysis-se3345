package project1.gui;

import project1.generator.DataGenerator;
import project1.generator.integer.IntegerAlmostOrderDataGenerator;
import project1.generator.integer.IntegerInOrderDataGenerator;
import project1.generator.integer.IntegerRandomOrderDataGenerator;
import project1.generator.integer.IntegerReverseOrderDataGenerator;

public final class IntegerGUIController extends GUIController<Integer> {
    @Override
    protected void initializeListProperties() {
        final DataGenerator<Integer> initialDataGenerator = new IntegerInOrderDataGenerator();

        dataGenerator = initialDataGenerator;
        inOrderButton.setUserData(initialDataGenerator);
        reverseOrderButton.setUserData(new IntegerReverseOrderDataGenerator());
        almostOrderButton.setUserData(new IntegerAlmostOrderDataGenerator());
        randomButton.setUserData(new IntegerRandomOrderDataGenerator());
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_AND_INTEGER_SORTS;
    }
}
