import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RelationCheckerTest {

    private RelationChecker relationChecker = new RelationChecker();

    @Test
    public void canExtractLeftEntityOfARelation() {
        assertThat(relationChecker.leftEntityOf("Library --> Book"), equalTo("Library"));
    }

    @Test
    public void canExtractRightEntityOfARelation() {
        assertThat(relationChecker.rightEntityOf("Continent --> Country"), equalTo("Country"));
    }

    @Test
    public void canExtractLinkOfARelation() {
        assertThat(relationChecker.linkOf("A --> B"), equalTo("-->"));
    }

    @Test
    public void verifyThatTheBuiltLinkExists() {
        relationChecker.linkFactory = mock(LinkFactory.class);
        Link specificLink = mock(Link.class);
        when(relationChecker.linkFactory.buildLink("-->")).thenReturn(specificLink);
        relationChecker.shouldExist("Building --> Room");

        verify(relationChecker.linkFactory).buildLink("-->");
        verify(specificLink).shouldExistBetweenTheGivenClasses("Building", "Room");
    }

    public class A {

    }

    public class B {

    }
}

