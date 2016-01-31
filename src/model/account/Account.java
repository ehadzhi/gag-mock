package model.account;

import model.IKernel;
import model.Kernel;
import model.Votable;
import model.post.Post;

public class Account extends Kernel implements IAccount {
	// TODO field : file avatar profile picture
	private String userName;
	private String password;
	private String eMail;
	private boolean showNSFWPosts;
	private boolean genderMale;
	private Post[] commentedPosts;
	private Post[] votedPosts;
	
	@Override
	public boolean upVote(Votable toUpVote) {
		// TODO Auto-generated method stub
		return false;
		
	}
	@Override
	public boolean downVote(Votable toDownVote) {
		// TODO Auto-generated method stub
		return false;
		
	}
	@Override
	public boolean deleteMe(IAccount whoDeletesMe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMyCreation(IKernel toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

}
