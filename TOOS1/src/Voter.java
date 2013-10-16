import Interfaces.IVoter;


public class Voter implements IVoter {
	
	private boolean _vote;
	public Voter(boolean vote)
	{
		_vote = vote;
	}

	@Override
	public boolean Vote() {
		return _vote;
	}

}
