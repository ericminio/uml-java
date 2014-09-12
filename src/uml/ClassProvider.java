package uml;

public class ClassProvider {

    private String packageName;

    public Class buildClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(packageName + "." + className);
            } catch (ClassNotFoundException exception) {
                throw new AssertionError("Class " + className + " not found");
            }
        }
    }

    public void willSearchInPackage(String packageName) {
        this.packageName = packageName;
    }
}
