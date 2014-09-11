import org.junit.Test;

public class BuildingTest {

    RelationChecker theFollowingRelation = new RelationChecker();

    @Test
    public void aBuildingCanHaveSeveralRooms() {
        theFollowingRelation.shouldExist("Building 1-->* Room");
    }

}
