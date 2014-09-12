package uml;

import java.lang.reflect.Method;

public class ParentReferenceChecker {

    public void shouldExistBetweenTheGivenClasses(Class leftClass, Class rightClass) {
        String leftEntity = leftClass.getSimpleName();
        String rightEntity = rightClass.getSimpleName();
        try {
            String leftEntityWithoutPackage = leftClass.getSimpleName();
            boolean found = false;
            Method[] methods = rightClass.getMethods();
            for(Method method:methods) {
                if (method.getName().matches("set(.)*" + leftEntityWithoutPackage)
                        && method.getParameterCount() == 1
                        && leftEntityWithoutPackage.equals(method.getParameters()[0].getType().getSimpleName())) {
                    found = true;
                }
            }
            if (!found) {
                throw new AssertionError("Class " + rightEntity + " should have a method with signature set*" + leftEntity + "(" + leftEntity + " a"+ leftEntity +")");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
