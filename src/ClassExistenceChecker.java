import sun.jvm.hotspot.utilities.AssertionFailure;

public class ClassExistenceChecker {

    public void shouldExist(String className) {
        checkThatTheClassExists(className);
    }

    private void checkThatTheClassExists(String className) {
        try {
            Class.forName(className).getConstructor().newInstance();
        }
        catch (Exception e) {
            throw new AssertionError("Class " + className + " not found");
        }
    }
}
