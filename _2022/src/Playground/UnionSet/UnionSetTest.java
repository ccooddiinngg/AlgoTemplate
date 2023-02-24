package Playground.UnionSet;

import org.junit.jupiter.api.Test;

class UnionSetTest {

    UnionSet unionSet = new UnionSet(10);

    @Test
    void test() {
        unionSet.union(1, 3);
        unionSet.union(1, 5);
        System.out.println(unionSet.isSameSet(3, 5));
        System.out.println(unionSet.isSameSet(2, 5));
    }
}