package uml;

import java.lang.reflect.Method;

public class AggregationChecker {

    private String leftEntity;
    private String rightEntity;

    public void shouldExistBetweenTheGivenClasses(Class leftClass, Class rightClass) {
        this.leftEntity = leftClass.getSimpleName();
        this.rightEntity = rightClass.getSimpleName();

        try {
            if (!LeftEntityHasAtLeastOneMethodThatTakesTheRightEntityTypeAsParameter()) {
                throw new AssertionError("Class " + leftEntity + " should have a method with signature *" + rightEntity + "(" + rightEntity + " a"+ rightEntity +")");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private boolean LeftEntityHasAtLeastOneMethodThatTakesTheRightEntityTypeAsParameter() throws ClassNotFoundException {
        String rightEntityWithoutPackage = Class.forName(rightEntity).getSimpleName();
        boolean found = false;
        Method[] methods = Class.forName(leftEntity).getMethods();
        for(Method method:methods) {
            if (method.getName().matches("(.)*" + rightEntityWithoutPackage)
                    && method.getParameterCount() == 1
                    && rightEntityWithoutPackage.equals(method.getParameters()[0].getType().getSimpleName())) {
                found = true;
            }
        }
        return found;
    }


}
