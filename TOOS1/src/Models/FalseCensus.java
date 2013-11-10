package Models;

public class FalseCensus extends Census {
	
	// return the total of voters that voted false
	public int getFalseVoters() {
		int falsevotes = 0;
		
		if (voters == null) {
			//returns a negative number if the voting has not taken place
			return -1;
		} else {
			for (Voter voter : voters) {
				if (!voter.vote()) falsevotes++;
			}
		}
		return falsevotes;
	}

}
