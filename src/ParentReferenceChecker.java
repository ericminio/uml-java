import java.lang.reflect.Method;

public class ParentReferenceChecker {

    public void shouldExistBetweenTheGivenClasses(String leftEntity, String rightEntity) {
        try {
            String leftEntityWithoutPackage = Class.forName(leftEntity).getSimpleName();
            boolean found = false;
            Method[] methods = Class.forName(rightEntity).getMethods();
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
