package AC2_Course.StackAndQueue;

public class ArrayLinkedList {
    int head;
    int[] e;
    int[] ne;
    int idx;

    public ArrayLinkedList(int C) {
        this.head = -1;
        this.idx = 0;
        e = new int[C];
        ne = new int[C];
    }

    public void addToHead(int val) {
        ne[idx] = head;
        e[idx] = val;
        head = idx;
        idx++;
    }

    public void addBehind(int k, int val) {
        ne[idx] = ne[k];
        e[idx] = val;
        ne[k] = idx;
        idx++;
    }

    public void deleteBehind(int k) {
        ne[k] = ne[ne[k]];
    }
}
