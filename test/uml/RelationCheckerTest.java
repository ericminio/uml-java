package uml;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class RelationCheckerTest {

    private RelationChecker relationChecker = new RelationChecker();
    private final Link specificLink = mock(Link.class);
    private final Class aClass = String.class;
    private final Class bClass = Object.class;

    @Before
    public void injectMockCollaborators() {
        relationChecker.theFollowingClass = mock(ClassExistenceChecker.class);
        relationChecker.linkFactory = mock(LinkFactory.class);

        when(relationChecker.theFollowingClass.shouldExist("A")).thenReturn(aClass);
        when(relationChecker.theFollowingClass.shouldExist("B")).thenReturn(bClass);
        when(relationChecker.linkFactory.buildLink("-->")).thenReturn(specificLink);
    }

    @Test
    public void lifeCycleSpecification() {
        relationChecker.theFollowingRelationShouldExist("A --> B");

        verify(relationChecker.theFollowingClass).shouldExist("A");
        verify(relationChecker.theFollowingClass).shouldExist("B");
        verify(relationChecker.linkFactory).buildLink("-->");
        verify(specificLink).shouldExistBetween(aClass, bClass);
    }

    @Test
    public void propagatesPackageInformationToClassExistenceChecker() {
        relationChecker.willSearchInPackage("here");

        verify(relationChecker.theFollowingClass).willSearchInPackage("here");
    }

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
}

