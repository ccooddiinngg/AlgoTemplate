package Stack;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    Integer v;
    List<NestedInteger> l;
    boolean single;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        single = false;
        l = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        single = true;
        v = value;
    }

    // @return true if this Stack.NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return single;
    }

    // @return the single integer that this Stack.NestedInteger holds, if it holds a single integer
    // Return null if this Stack.NestedInteger holds a nested list
    public Integer getInteger() {
        return single ? v : null;
    }

    // Set this Stack.NestedInteger to hold a single integer.
    public void setInteger(int value) {
        if (single) {
            v = value;
        }
    }

    // Set this Stack.NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (!single) {
            l.add(ni);
        }
    }

    // @return the nested list that this Stack.NestedInteger holds, if it holds a nested list
    // Return empty list if this Stack.NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return single ? null : l;
    }
}