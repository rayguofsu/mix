Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.

Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);




public class Twitter {
    Map<Integer, User> map;
    private static int timeStamp = 0;
    private class Twit{
        int time, id;
        Twit next;
        Twit(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    public class User{
        int id;
        Twit headTwit;
        Set<Integer> followed;
        User(int id){
            this.id = id;
            followed =  new HashSet<>();
            followed.add(id);
            headTwit = null;
        }
        void follow(int id){
            followed.add(id);
        }
        void unfollow(int id){
            followed.remove(id);
        }
    }



    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)){
            map.put(userId, new User(userId));
        }
        User u = map.get(userId);
        Twit t = new Twit(tweetId);
        t.next = u.headTwit;
        u.headTwit = t;
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        User u = map.get(userId); if (u == null) return res;
        PriorityQueue<Twit> pq = new PriorityQueue<Twit>(map.size(), new Comparator<Twit>(){
            public int compare(Twit t1, Twit t2){
                return t2.time - t1.time;
            }
        });
        for (int i: map.get(userId).followed){
            User tmp = map.get(i);
            if (tmp.headTwit != null){
                pq.offer(tmp.headTwit);
            }
        }
        int n = 0;
        while(!pq.isEmpty() && n < 10){
            Twit t = pq.poll();
            if (t.next != null) pq.offer(t.next);
            res.add(t.id);
            n++;
        }
        return res;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) map.put(followerId, new User(followerId));
        if (!map.containsKey(followeeId)) map.put(followeeId, new User(followeeId));
        map.get(followerId).followed.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || followerId==followeeId)
            return;
        map.get(followerId).unfollow(followeeId);
        
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
