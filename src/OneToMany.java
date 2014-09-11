public class OneToMany implements Link {

    AggregationChecker anAggregation = new AggregationChecker();
    ParentReferenceChecker aParentReference = new ParentReferenceChecker();

    @Override
    public void shouldExistBetweenTheGivenClasses(String leftEntity, String rightEntity) {
        anAggregation.shouldExistBetweenTheGivenClasses(leftEntity, rightEntity);
        aParentReference.shouldExistBetweenTheGivenClasses(leftEntity, rightEntity);
    }
}
