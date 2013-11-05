package Models;


public class Voter {
	
	private boolean _vote;
	public Voter(boolean vote)
	{
		_vote = vote;
	}

	
	public boolean vote() {
		return _vote;
	}

}
