package project1.generator.integer;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

public final class IntegerDataGeneratorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<InOrderDataGenerator<Integer>>() {}).to(IntegerInOrderDataGenerator.class);
        bind(new TypeLiteral<ReverseOrderDataGenerator<Integer>>() {}).to(IntegerReverseOrderDataGenerator.class);
        bind(new TypeLiteral<AlmostOrderDataGenerator<Integer>>() {}).to(IntegerAlmostOrderDataGenerator.class);
        bind(new TypeLiteral<RandomOrderDataGenerator<Integer>>() {}).to(IntegerRandomOrderDataGenerator.class);
    }
}
