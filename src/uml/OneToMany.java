package uml;

public class OneToMany implements Link {

    AggregationChecker anAggregation = new AggregationChecker();
    ParentReferenceChecker aParentReference = new ParentReferenceChecker();

    @Override
    public void shouldExistBetween(Class leftClass, Class rightClass) {
        anAggregation.shouldExistBetweenTheGivenClasses(leftClass, rightClass);
        aParentReference.shouldExistBetweenTheGivenClasses(leftClass, rightClass);
    }
}
