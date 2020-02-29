package project1.gui;

public final class IntegerGUIController extends GUIController<Integer> {
    public IntegerGUIController() {
        super(Integer.class);
    }

    @Override
    GUIType getGUIType() {
        return GUIType.UNIVERSAL_AND_INTEGER_SORTS;
    }
}
