package ass2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import Models.Census;
import Models.TrueCensus;
import Models.FalseCensus;
import Models.Voter;

/*
 * 1. the returned value must be false only if at least one voter votes false
 * 2  if all voters vote true then the return value must be true
 * 3. every valid (i.e. non-null) voter must vote
 * 4. no voter can vote more than once.
 * */

public class CensusTest {

	private static ArrayList<Voter> voters;
	private static ArrayList<Voter> votersToCheck;
	private static Census census;
	private static TrueCensus truecensus;
	private static FalseCensus falsecensus;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Before
	public void emptyList(){
		voters = new ArrayList<Voter>();
		votersToCheck = new ArrayList<Voter>();
		census  = new Census();
		truecensus = new TrueCensus();
		falsecensus = new FalseCensus();
	}
	
	//3. every valid (i.e. non-null) voter must vote
	//4. no voter can vote more than once
	@After
	public void endTest(){
		for(Voter v : votersToCheck){
	    	if(v != null)
	    		verify(v, times(1)).vote();
	    }
	}
	
	@Test
	public void emptyList_should_return_true()  {
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}
	
	@Test
	public void list_with_one_true_vote_should_return_true()  {
		addVoterToList(true);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}
	
	@Test
	public void list_with_one_false_vote_should_return_false()  {
		addVoterToList(false);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertFalse(result);
	    assertFalse(trueresult);
	    assertFalse(falseresult);
	}
	
	@Test
	public void list_with_a_null_voter_should_return_true()  {
		voters.add(null);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}
	
	@Test
	public void false_true_voters_should_return_false()  {
		addVoterToList(false);		
		addVoterToList(true);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertFalse(result);
	    assertFalse(trueresult);
	    assertFalse(falseresult);
	}
	
	@Test
	public void true_false_voters_should_return_false()  {
		addVoterToList(true);
		addVoterToList(false);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertFalse(result);
	    assertFalse(trueresult);
	    assertFalse(falseresult);
	}
	
	@Test
	public void double_true_voters_should_vote_only_once()  {
		Voter voter = addVoterToList(true);		
		voters.add(voter);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}
	
	@Test
	public void double_false_voters_should_vote_only_once()  {
		Voter voter = addVoterToList(false);		
		voters.add(voter);
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		// test the result
	    assertFalse(result);
	    assertFalse(trueresult);
	    assertFalse(falseresult);
	}
	
	@Test
	public void list_of_null_voters_should_return_true() {
		
		int listlength = 20;
		
		// make list of 20 items
		for(int i =0; i < listlength; i++) {
			voters.add(null);
		}
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}
	
	@Test
	public void list_of_false_voters_should_return_false() {
		
		int listlength = 20;
		
		// make list of 20 items
		for(int i =0; i < listlength; i++) {
			addVoterToList(false);
		}
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		assertFalse(result);
	    assertFalse(trueresult);
	    assertFalse(falseresult);
	}
	
	@Test
	public void list_of_true_voters_should_return_true() {
		
		int listlength = 20;
		
		// make list of 20 items
		for(int i =0; i < listlength; i++) {
			addVoterToList(true);
		}
		
		boolean result = census.voting(voters);
		boolean trueresult = truecensus.voting(voters);
		boolean falseresult = falsecensus.voting(voters);
		
		assertTrue(result);
	    assertTrue(trueresult);
	    assertTrue(falseresult);
	}		

	//create voter with a specific return value for vote
	private Voter addVoterToList(boolean vote) {
		
		Voter voterMock = mock(Voter.class);
		when(voterMock.vote()).thenReturn(vote);
		voters.add(voterMock);
		
		//add to 'votersToCheck' list (used to check if voters can vote twice if you add them twice to the voters list)
		votersToCheck.add(voterMock);
		
		return voterMock;
	}
}
