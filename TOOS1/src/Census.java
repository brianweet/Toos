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
		
		//no voter can vote more than once.  
		//TODO BwE:Are we going to check if all voters only appear once in the list??
		for (IVoter voter : voters) {
			if(voter == null)
				continue;
			
			boolean vote = voter.Vote();
			
			//the returned value must be false only if at least one voter votes false
			if(!vote)
				return vote;
			
			//if all voters vote true then the return value must be true
			result = true;
		}
		
		return result;
	}

}
