package model.account;

import model.IKernel;
import model.Votable;

public interface IAccount extends IKernel {
	
	boolean upVote(Votable toUpVote);
	
	boolean downVote(Votable toDownVote);
	
	boolean deleteMyCreation(IKernel toDelete);
}
