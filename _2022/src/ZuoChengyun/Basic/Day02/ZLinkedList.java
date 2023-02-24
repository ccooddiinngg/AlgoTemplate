package ZuoChengyun.Basic.Day02;


public class ZLinkedList {
    public ZListNode head;

    public ZLinkedList() {
    }

    public ZLinkedList(int val) {
        head = new ZListNode(val);
    }

    public void insert(int val) {
        if (head == null) {
            head = new ZListNode(val);
            return;
        }
        ZListNode node = new ZListNode(val);
        ZListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void insert(ZListNode node) {
        if (head == null) {
            head = node;
            return;
        }
        ZListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void print() {
        ZListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " => ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public ZListNode reverse(ZListNode node) {
        if (node.next == null) {
            this.head = node;
            return node;
        }
        ZListNode nextNode = reverse(node.next);
        nextNode.next = node;
        node.next = null;
        return node;
    }

    public void remove(int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ZListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        ZLinkedList list = new ZLinkedList(5);
        list.insert(5);
        list.insert(5);
        list.insert(4);
        list.insert(7);
        list.insert(2);
        list.insert(2);
        list.print();

//        list.reverse(list.head);
        list.remove(4);
        list.remove(2);
        list.remove(5);
        list.remove(7);
        list.print();
    }
    
}
