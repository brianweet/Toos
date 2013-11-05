package ass1;
import java.util.ArrayList;

import Models.Census;
import Models.Voter;

public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<Voter> voters = new ArrayList<Voter>();
		
		Voter nullvoter = null;
		Voter voter1 = new Voter(true);
		Voter voter2 = new Voter(false);
		
		voters.add(nullvoter);		
		voters.add(voter1);
		voters.add(voter1);
		voters.add(voter2);
		
		Census census = new Census();
		
		boolean result = census.voting(voters);
	}

}
