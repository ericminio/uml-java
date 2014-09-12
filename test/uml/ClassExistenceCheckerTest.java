package uml;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ClassExistenceCheckerTest {

    ClassExistenceChecker theFollowingClass = new ClassExistenceChecker();

    @Test(expected = AssertionError.class)
    public void failsWhenClassCanNotBeFound() {
        theFollowingClass.shouldExist("UnknownClass");
    }

    @Test
    public void passesWhenClassExists() {
        theFollowingClass.shouldExist("uml.ClassExistenceChecker");
    }

    @Test
    public void searchesInGivenPackages() {
        theFollowingClass.willSearchInPackage("uml");
        theFollowingClass.shouldExist("ClassExistenceChecker");
    }

    @Test
    public void returnsTheFoundClass() throws IllegalAccessException, InstantiationException {
        Class thisClass = theFollowingClass.shouldExist("uml.ClassExistenceChecker");
        assertThat(thisClass.newInstance(), instanceOf(ClassExistenceChecker.class));
    }
}
