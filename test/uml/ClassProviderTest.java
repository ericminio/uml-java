package uml;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ClassProviderTest {

    @Test
    public void canFindAClassWithinAPackage() throws IllegalAccessException, InstantiationException {
        assertThat(new ClassProvider().buildClass("uml.ClassProvider").newInstance(), instanceOf(ClassProvider.class));
    }

    @Test(expected = AssertionError.class)
    public void canNotFindAnUnknownClass() throws IllegalAccessException, InstantiationException {
        new ClassProvider().buildClass("ClassProvider");
    }

    @Test
    public void extendsSearchToTheGivenPackage() throws IllegalAccessException, InstantiationException {
        ClassProvider classProvider = new ClassProvider();
        classProvider.willSearchInPackage("uml");
        assertThat(classProvider.buildClass("ClassProvider").newInstance(), instanceOf(ClassProvider.class));
    }
}
