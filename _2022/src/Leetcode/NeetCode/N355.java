package Leetcode.NeetCode;

import java.util.*;

public class N355 {
    class User {
        int id;
        Tweet tweetHead;
        Set<Integer> followees;

        public User(int id) {
            this.id = id;
            tweetHead = null;
            followees = new HashSet<>();
            followees.add(id);
        }

        public void follow(int followeeId) {
            followees.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (followees.contains(followeeId) && followeeId != id) {
                followees.remove(followeeId);
            }
        }

        public void post(int tweetId) {
            Tweet t = new Tweet(id, tweetId);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    class Tweet {
        int userId;
        int time;
        int tweetId;
        Tweet next;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.time = timestamp++;
            this.tweetId = tweetId;
            next = null;
        }
    }

    int timestamp;
    Map<Integer, User> users;

    public N355() {
        timestamp = 0;
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            User u = new User(userId);
            users.put(userId, u);
        }
        users.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!users.containsKey(userId)) {
            return res;
        }

        Set<Integer> followees = users.get(userId).followees;
        Queue<Tweet> tweets = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int followee : followees) {
            User user = users.get(followee);
            if (user != null && user.tweetHead != null) {
                tweets.add(user.tweetHead);
            }
        }
        int count = 10;
        while (!tweets.isEmpty() && count > 0) {
            Tweet t = tweets.poll();
            res.add(t.tweetId);
            if (t.next != null) {
                tweets.add(t.next);
            }
            count--;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            User u = new User(followerId);
            users.put(followerId, u);
        }
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).unfollow(followeeId);
        }
    }

    //["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
    //[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
    public static void main(String[] args) {
        N355 twitter = new N355();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
