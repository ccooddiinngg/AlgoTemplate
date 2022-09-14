package tag.design;

import java.util.*;

class Twitter {
    Map<Integer, User> map;

    public Twitter() {
        this.map = new HashMap<>();
    }

    private User getUser(int userId) {
        if (!map.containsKey(userId)) {
            User user = new User(userId);
            map.put(userId, user);
        }
        return map.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.tweet(tweetId);
    }

    int max = 10;

    //use priority queue save all head, get the desire one and adds its next to the q
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        Queue<Tweet> q = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        for (Integer followee : user.followees) {
            Tweet tweet = map.get(followee).head;
            if (tweet != null) {
                q.offer(tweet);
            }
        }
        List<Integer> list = new ArrayList<>();
        int count = max;
        while (count > 0 && !q.isEmpty()) {
            Tweet tweet = q.poll();
            if (tweet.next != null) {
                q.offer(tweet.next);
            }
            list.add(tweet.tweetId);
            count--;
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        User followee = getUser(followeeId);
        user.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.unfollow(followeeId);
    }

    class User {
        int userId;
        Tweet head;
        Set<Integer> followees;

        public User(int userId) {
            this.userId = userId;
            this.head = null;
            this.followees = new HashSet<>();
            this.followees.add(userId);
        }

        void tweet(int tweetId) {
            Tweet tweet = new Tweet(userId, tweetId);
            tweet.next = head;
            head = tweet;
        }

        void follow(int followeeId) {
            this.followees.add(followeeId);
        }

        void unfollow(int followeeId) {
            this.followees.remove(followeeId);
        }
    }

    int timer = 0;

    class Tweet {
        int userId;
        int tweetId;
        int timestamp;
        Tweet next;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timer++;
            this.next = null;
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
