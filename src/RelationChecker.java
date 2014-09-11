public class RelationChecker {

    ClassExistenceChecker theFollowingClass = new ClassExistenceChecker();
    LinkFactory linkFactory = new LinkFactory();

    public void shouldExist(String relation) {
        String leftEntity = leftEntityOf(relation);
        String rightEntity = rightEntityOf(relation);

        theFollowingClass.shouldExist(leftEntity);
        theFollowingClass.shouldExist(rightEntity);
        linkFactory.buildLink(linkOf(relation)).shouldExistBetweenTheGivenClasses(leftEntity, rightEntity);
    }

    protected String leftEntityOf(String relation) {
        return segmentsOf(relation)[0];
    }

    protected String linkOf(String relation) {
        return segmentsOf(relation)[1];
    }

    protected String rightEntityOf(String relation) {
        return segmentsOf(relation)[2];
    }

    private String[] segmentsOf(String relation) {
        return relation.split("\\s");
    }

}
