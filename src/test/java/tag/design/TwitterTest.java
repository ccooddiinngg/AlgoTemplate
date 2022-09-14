package tag.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TwitterTest {
    /*
    ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
    [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
    */
    @Test
    void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        Assertions.assertEquals(List.of(5), twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        Assertions.assertEquals(List.of(6, 5), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        Assertions.assertEquals(List.of(5), twitter.getNewsFeed(1));
    }

}