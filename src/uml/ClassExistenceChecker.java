package uml;

public class ClassExistenceChecker {

    ClassProvider classProvider = new ClassProvider();

    public void willSearchInPackage(String packageName) {
        classProvider.willSearchInPackage(packageName);
    }

    public Class shouldExist(String className) {
        return classProvider.buildClass(className);
    }
}
