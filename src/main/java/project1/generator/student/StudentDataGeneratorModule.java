package project1.generator.student;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import project1.data.Student;
import project1.generator.AlmostOrderDataGenerator;
import project1.generator.InOrderDataGenerator;
import project1.generator.RandomOrderDataGenerator;
import project1.generator.ReverseOrderDataGenerator;

public final class StudentDataGeneratorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<InOrderDataGenerator<Student>>() {}).to(StudentInOrderDataGenerator.class);
        bind(new TypeLiteral<ReverseOrderDataGenerator<Student>>() {}).to(StudentReverseOrderDataGenerator.class);
        bind(new TypeLiteral<AlmostOrderDataGenerator<Student>>() {}).to(StudentAlmostOrderDataGenerator.class);
        bind(new TypeLiteral<RandomOrderDataGenerator<Student>>() {}).to(StudentRandomOrderDataGenerator.class);
    }
}
