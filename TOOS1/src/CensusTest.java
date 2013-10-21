import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Interfaces.ICensus;
import Interfaces.IVoter;


public class CensusTest {
	
	private static IVoter voter1true;
	private static IVoter voter2false;
	private static ArrayList<IVoter> voters;

	@BeforeClass
	  public static void testSetup() {
		voter1true = new Voter(true);
		voter2false = new Voter(false);
	  }
	
	@Before
	public void emptyList(){
		voters = new ArrayList<IVoter>();
	}

	@Test
	  public void FirstPredicate_CaseOne_OneTrueVoter() {
		voters.add(voter1true);
		
		ICensus census = new Census();
		assertEquals("One true voter should be true",true,census.voting(voters));
	  }
	
	@Test
	  public void FirstPredicate_CaseTwo_OneFalseVoter() {;
		voters.add(voter2false);
		
		ICensus census = new Census();
		assertEquals("One false voter should be false",false,census.voting(voters));
	  }
	
	@Test
	  public void SecondPredicate_CaseOne_NullVoterAndTrueVoter() {
		voters.add(null);       
		voters.add(voter1true);
		
		ICensus census = new Census();
		assertEquals("One true voter should be true",true,census.voting(voters));
	  }
	
	@Test
	  public void SecondPredicate_CaseTwo_DoubleTrueVoter() {
		voters.add(voter1true);       
		voters.add(voter1true);
		
		ICensus census = new Census();
		assertEquals("Double true voter should be true",true,census.voting(voters));
	  }
	
	@Test
	  public void SecondPredicate_CaseThree_TrueVoterAndFalseVoter() {
		voters.add(voter1true);       
		voters.add(voter2false);
		
		ICensus census = new Census();
		assertEquals("At least one false voter should be false",false,census.voting(voters));
	  }
	
	

}
