import org.junit.Test;
import uml.RelationChecker;

public class BuildingTest {

    RelationChecker theFollowingRelation = new RelationChecker();

    @Test
    public void aBuildingCanHaveSeveralRooms() {
        theFollowingRelation.theFollowingRelationShouldExist("Building 1-->* Room");
    }

}
