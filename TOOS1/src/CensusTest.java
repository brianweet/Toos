import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import Interfaces.ICensus;
import Interfaces.IVoter;


public class CensusTest {
	
	private static IVoter voter1true;
	private static IVoter voter2false;

	@BeforeClass
	  public static void testSetup() {
		voter1true = new Voter(true);
		voter2false = new Voter(false);
	  }

	@Test
	  public void FirstPredicate_CaseOne_OneTrueVoter() {
		ArrayList<IVoter> voters = new ArrayList<IVoter>();		
		voters.add(voter1true);
		
		ICensus census = new Census();
		assertEquals("One true voter should be true",true,census.voting(voters));
	  }
	
	@Test
	  public void FirstPredicate_CaseTwo_OneFalseVoter() {
		ArrayList<IVoter> voters = new ArrayList<IVoter>();
		voters.add(voter2false);
		
		ICensus census = new Census();
		assertEquals("One false voter should be false",false,census.voting(voters));
	  }
	
	@Test
	  public void SecondPredicate_CaseOne_NullVoterAndTrueVoter() {
		ArrayList<IVoter> voters = new ArrayList<IVoter>();
		
		voters.add(null);       
		voters.add(voter1true);
		
		ICensus census = new Census();
		assertEquals("One false voter should be false",false,census.voting(voters));
	  }

}
