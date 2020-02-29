package project1;

import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

@SuppressWarnings("unchecked")
public final class TypeLiteralUtilities {
    public static <E extends Comparable<E>> TypeLiteral<InOrderDataGenerator<E>> getInOrderDataGenerator(Class<E> type) {
        return (TypeLiteral<InOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(InOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<ReverseOrderDataGenerator<E>> getReverseOrderDataGenerator(Class<E> type) {
        return (TypeLiteral<ReverseOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(ReverseOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<AlmostOrderDataGenerator<E>> getAlmostOrderDataGenerator(Class<E> type) {
        return (TypeLiteral<AlmostOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(AlmostOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<RandomOrderDataGenerator<E>> getRandomOrderDataGenerator(Class<E> type) {
        return (TypeLiteral<RandomOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(RandomOrderDataGenerator.class, type));
    }
}
