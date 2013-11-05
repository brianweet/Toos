package ass2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import Models.Census;
import Models.Voter;

public class CensusTest {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
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
	}

}
