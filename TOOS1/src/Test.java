import java.util.ArrayList;

import Interfaces.ICensus;
import Interfaces.IVoter;

public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<IVoter> voters = new ArrayList<IVoter>();
		
		IVoter nullvoter = null;
		IVoter voter1 = new Voter(true);
		IVoter voter2 = new Voter(false);
		
		voters.add(nullvoter);		
		voters.add(voter1);
		voters.add(voter1);
		voters.add(voter2);
		
		ICensus census = new Census();
		
		boolean result = census.voting(voters);
	}

}
