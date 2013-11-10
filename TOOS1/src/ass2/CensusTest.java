package ass2;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import Models.Census;
import Models.Voter;

/*
 * 1. the returned value must be false only if at least one voter votes false
 * 2  if all voters vote true then the return value must be true
 * 3. every valid (i.e. non-null) voter must vote
 * 4. no voter can vote more than once.
 * */

public class CensusTest {

	private static ArrayList<Voter> voters;
	private static Census census;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Before
	public void emptyList(){
		voters = new ArrayList<Voter>();
		census  = new Census();
	}
	
	@Test
	public void emptyList_should_return_true()  {
		boolean result = census.voting(voters);
		// test the result
	    assertTrue(result);
	}
	
	@Test
	public void list_with_one_true_vote_should_return_true()  {
		//create voter with a specific return value for vote
		Voter voterMock = mock(Voter.class);
		when(voterMock.vote()).thenReturn(true);
		
		voters.add(voterMock);
		
		boolean result = census.voting(voters);
		// test the result
	    assertTrue(result);
	}
	
	@Test
	public void list_with_one_false_vote_should_return_false()  {
		//create voter with a specific return value for vote
		Voter voterMock = mock(Voter.class);
		when(voterMock.vote()).thenReturn(false);
		
		voters.add(voterMock);
		
		boolean result = census.voting(voters);
		// test the result
	    assertFalse(result);
	}
	
	@Test
	public void list_with_a_null_voter_should_return_true()  {
		voters.add(null);
		
		boolean result = census.voting(voters);
		// test the result
	    assertTrue(result);
	}
	
	
	
	/*@Test
	public void test()  {
		Census c  = new Census();
		
		//create voter with a specific return value for vote
		Voter voterMock = mock(Voter.class);
		when(voterMock.vote()).thenReturn(true);
		
		ArrayList<Voter> voterList = new ArrayList<Voter>();
		voterList.add(voterMock);
		
		boolean result = c.voting(voterList);

	    // test the result
	    assertTrue(result);
	}*/

}
