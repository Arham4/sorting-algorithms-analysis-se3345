package project1.generator;

import project1.StringUtilities;

public enum DataType {
    IN_ORDER,
    REVERSE_ORDER,
    ALMOST_ORDER,
    RANDOM,
    ;

    @Override
    public String toString() {
        return StringUtilities.capitalizeWords(name()).replaceAll(" ", "");
    }
}
