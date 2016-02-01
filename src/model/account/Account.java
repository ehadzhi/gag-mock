package model.account;

import model.IKernel;
import model.Kernel;
import model.Votable;
import model.comment.Comment;
import model.post.Post;
import model.section.ISection;

public class Account extends Kernel implements IAccount {
	// TODO field : file avatar profile picture
	private String userName;
	private String password; // very bad :D
	private String eMail;
	private boolean showNSFWPosts;
	private boolean genderMale;
	private ISection commentedPosts;
	private ISection votedPosts;

	@Override
	public boolean upVote(Votable toUpVote) {
		if (toUpVote != null) {
			toUpVote.upVote();
			if (toUpVote instanceof Post) {
				// TODO add Post to voted
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean downVote(Votable toDownVote) {
		if (toDownVote != null) {
			toDownVote.downVote();
			if (toDownVote instanceof Post) {
				// TODO add Post to voted
			}
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteMe(IAccount whoDeletesMe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMyCreation(IKernel toDelete) {
		if (toDelete != null) {
			return toDelete.deleteMe(this);
		}
		return false;
	}

}
