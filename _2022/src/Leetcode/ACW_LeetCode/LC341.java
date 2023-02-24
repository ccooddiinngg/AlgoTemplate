package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC341 {
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            flat(nestedList);
            it = list.iterator();
        }

        void flat(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    flat(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
// Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
// Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
