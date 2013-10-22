import java.util.ArrayList;
import Interfaces.ICensus;
import Interfaces.IVoter;


public class Census implements ICensus {
	
	/* 
	  	1. the returned value must be false only if at least one voter votes false
		2  if all voters vote true then the return value must be true
		3. every valid (i.e. non-null) voter must vote
		4. no voter can vote more than once.
	 * */
	
	@Override
	public boolean voting(ArrayList<IVoter> voters) {
		boolean result = false;
		ArrayList<IVoter> handledVoters = new ArrayList<IVoter>();
		  
		for (IVoter voter : voters) {				
			//every valid (i.e. non-null) voter must vote
			//no voter can vote more than once.
			if(voter == null || handledVoters.contains(voter))				
				continue;
			
			boolean vote = voter.Vote();
			
			//the returned value must be false only if at least one voter votes false
			if(!vote)
				return false;
			
			//track voters who already voted
			handledVoters.add(voter);
			
			//if all voters vote true then the return value must be true
			result = true;
		}
		
		return result;
	}

}
