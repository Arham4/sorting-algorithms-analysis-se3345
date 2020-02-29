package project1;

import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

/**
 * Absolutely necessary meme: https://i.imgur.com/Ee74oQ5.png
 */
@SuppressWarnings("unchecked")
public final class TypeLiteralUtilities {
    public static <E extends Comparable<E>> TypeLiteral<InOrderDataGenerator<E>> getInOrderDataGeneratorTypeLiteral(Class<E> type) {
        return (TypeLiteral<InOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(InOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<ReverseOrderDataGenerator<E>> getReverseOrderDataGeneratorTypeLiteral(Class<E> type) {
        return (TypeLiteral<ReverseOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(ReverseOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<AlmostOrderDataGenerator<E>> getAlmostOrderDataGeneratorTypeLiteral(Class<E> type) {
        return (TypeLiteral<AlmostOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(AlmostOrderDataGenerator.class, type));
    }

    public static <E extends Comparable<E>> TypeLiteral<RandomOrderDataGenerator<E>> getRandomOrderDataGeneratorTypeLiteral(Class<E> type) {
        return (TypeLiteral<RandomOrderDataGenerator<E>>) TypeLiteral.get(Types.newParameterizedType(RandomOrderDataGenerator.class, type));
    }
}
