package AC2_Course.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*839 模拟堆
维护一个集合，初始时集合为空，支持如下几种操作：

I x，插入一个数 x；
PM，输出当前集合中的最小值；
DM，删除当前集合中的最小值（数据保证此时的最小值唯一）；
D k，删除第 k 个插入的数；
C k x，修改第 k 个插入的数，将其变为 x；
*/

//! BUG
public class A839 {
    static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    //heap
    Node[] heap = new Node[100010];
    int size = 0;

    public A839() {
    }

    //sequence of inserted number
    List<Node> list = new ArrayList<>();

    //node:index
    Map<Node, Integer> map = new HashMap<>();

    public void up(int index) {
        int pIdx = (index - 1) / 2;
        while ((index - 1) / 2 >= 0 && heap[(index - 1) / 2].val > heap[index].val) {
            swap(heap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public void down(int index) {
        while (index * 2 + 1 < size) {
            int minIdx = index * 2 + 1;
            if (index * 2 + 2 < size && heap[index * 2 + 2].val < heap[minIdx].val) {
                minIdx = index * 2 + 2;
            }
            if (heap[index].val > heap[minIdx].val) {
                swap(heap, index, minIdx);
                index = minIdx;
            } else {
                break;
            }
        }
    }

    public void add(int v) {
        Node node = new Node(v);
        list.add(node);
        heap[size] = node;
        map.put(node, size);
        up(size);
        size++;
    }

    public int peek() {
        if (!isEmpty()) {
            return heap[0].val;
        }
        throw new NullPointerException();
    }

    public int pop() {
        if (!isEmpty()) {
            int v = heap[0].val;
            swap(heap, 0, size - 1);
            size--;
            down(0);
            return v;
        }
        throw new NullPointerException();
    }

    public void delete(int k) {
        Node node = list.get(k - 1);
        int index = map.get(node);
        if (index < size) {
            swap(heap, index, size - 1);
            size--;
            down(index);
        }
    }

    public void update(int k, int val) {
        Node node = list.get(k - 1);
        int index = map.get(node);
        if (index < size) {
            heap[index].val = val;
            down(index);
            up(index);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(Node[] heap, int i, int j) {
        Node t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
        map.put(heap[i], i);
        map.put(heap[j], j);
    }
}
