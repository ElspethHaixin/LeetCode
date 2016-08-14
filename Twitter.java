import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Twitter {
	private class Tweet {
		int userId;
		int tweetId;
		Tweet(int userId, int tweetId) {
			this.userId = userId;
			this.tweetId = tweetId;
		}
	}
	
	private List<Tweet> tweets;
	private HashMap<Integer, List<Integer>> follows;

	/** Initialize your data structure here. */
	public Twitter() {
		tweets = new ArrayList<Tweet>();
		follows = new HashMap<Integer, List<Integer>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		tweets.add(new Tweet(userId, tweetId));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> ret = new LinkedList<Integer>();
		int len = tweets.size();
		int cnt = 0;
		for (int i = len - 1; i != -1; i--) {
			int id = tweets.get(i).userId;
			if (id == userId || isFollowed(userId, id)) {
				ret.add(tweets.get(i).tweetId);
				cnt++;
				if (cnt == 10)
					break;
			}
		}
		return ret;
	}
	
	private boolean isFollowed(int userId, int id) {
		List<Integer> l = follows.get(userId);
		
		if (l == null)
			return false;
		
		else {
			for (int i : l)
				if (i == id)
					return true;
		}
		
		return false;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		List<Integer> l = follows.get(followerId);
		
		if (l == null) {
			l = new ArrayList<Integer>();
			l.add(followeeId);
			follows.put(followerId, l);
		}
		
		else {
			for (int i : l)
				if (i == followeeId)
					return;
			l.add(followeeId);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		List<Integer> l = follows.get(followerId);
		
		if (l != null) {
			int len = l.size();
			for (int i = 0; i < len; i++)
				if (l.get(i) == followeeId) {
					l.remove(i);
					break;
				}
		}
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
