package Leetcode.ACW_LeetCode;

import java.util.*;

public class LC355 {
    class Twitter {
        int timestamp;
        Map<Integer, User> map;

        public Twitter() {
            timestamp = 0;
            map = new HashMap<>();
        }

        void creatUser(int userId) {
            if (map.containsKey(userId)) return;
            map.put(userId, new User(userId));
        }

        User getUser(int userId) {
            if (!map.containsKey(userId)) {
                creatUser(userId);
            }
            return map.get(userId);
        }

        class User {
            int userId;
            Set<Integer> followees;
            Tweet head;

            public User(int userId) {
                this.userId = userId;
                followees = new HashSet<>();
                followees.add(userId);
                head = null;
            }

            void post(int tweetId) {
                Tweet tweet = new Tweet(tweetId);
                tweet.next = head;
                head = tweet;
            }

            void follow(int followeeId) {
                followees.add(followeeId);
            }

            void unfollow(int followeeId) {
                if (followeeId == userId) return;
                followees.remove(followeeId);
            }
        }

        class Tweet {
            int time;
            int tweetId;
            Tweet next;

            public Tweet(int tweetId) {
                this.tweetId = tweetId;
                time = timestamp++;
                next = null;
            }
        }

        public void postTweet(int userId, int tweetId) {
            User user = getUser(userId);
            user.post(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> list = new ArrayList<>();
            Queue<Tweet> q = new PriorityQueue<>((a, b) -> a.time - b.time);
            Set<Integer> followees = getUser(userId).followees;
            for (int followeeId : followees) {
                User followee = getUser(followeeId);
                Tweet p = followee.head;
                int k = 10;
                while (p != null && k > 0) {
                    q.add(p);
                    p = p.next;
                    k--;
                }
                while (q.size() > 10) q.poll();
            }
            while (!q.isEmpty()) {
                list.add(0, q.poll().tweetId);
            }
            return list;
        }

        public void follow(int followerId, int followeeId) {
            User user = getUser(followerId);
            user.follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            User user = getUser(followerId);
            user.unfollow(followeeId);
        }
    }
}
