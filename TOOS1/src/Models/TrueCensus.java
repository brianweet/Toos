package Models;

public class TrueCensus extends Census {
	
	
	// return the total of voters that voted true
	public int getTrueVoters() {
		int truevotes = 0;
		
		if (voters == null) {
			//returns a negative number if the voting has not taken place
			return -1;
		} else {
			for (Voter voter : voters) {
				if (voter.vote()) truevotes++;
			}
		}
		return truevotes;
	}

}
