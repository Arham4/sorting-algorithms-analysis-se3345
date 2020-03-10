package project1.generator;

import com.google.inject.AbstractModule;
import project1.generator.integer.IntegerDataGeneratorModule;

public class DataGeneratorModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new IntegerDataGeneratorModule());
    }
}
