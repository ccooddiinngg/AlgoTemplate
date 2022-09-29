package tag.Design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DesignTwitterTest {
    /*
    ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
    [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
    */
    @Test
    void test() {
        DesignTwitter designTwitter = new DesignTwitter();
        designTwitter.postTweet(1, 5);
        Assertions.assertEquals(List.of(5), designTwitter.getNewsFeed(1));
        designTwitter.follow(1, 2);
        designTwitter.postTweet(2, 6);
        Assertions.assertEquals(List.of(6, 5), designTwitter.getNewsFeed(1));
        designTwitter.unfollow(1, 2);
        Assertions.assertEquals(List.of(5), designTwitter.getNewsFeed(1));
    }

}