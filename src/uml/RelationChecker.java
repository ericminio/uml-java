package uml;

public class RelationChecker {

    ClassExistenceChecker theFollowingClass = new ClassExistenceChecker();
    LinkFactory linkFactory = new LinkFactory();

    public void willSearchInPackage(String packageName) {
        theFollowingClass.willSearchInPackage(packageName);
    }

    public void theFollowingRelationShouldExist(String relation) {
        String leftEntity = leftEntityOf(relation);
        String rightEntity = rightEntityOf(relation);

        Class leftClass = theFollowingClass.shouldExist(leftEntity);
        Class rightClass = theFollowingClass.shouldExist(rightEntity);
        theLinkIn(relation).shouldExistBetween(leftClass, rightClass);
    }

    private Link theLinkIn(String relation) {
        return linkFactory.buildLink(linkOf(relation));
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
