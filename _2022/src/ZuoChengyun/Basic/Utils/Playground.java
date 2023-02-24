package ZuoChengyun.Basic.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Playground {

    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("A");
        Student s2 = new Student("B");

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);

        List<Student> list2 = new ArrayList<>(list1);

        System.out.println(list1);
        System.out.println(list2);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.pollFirst();
        linkedList.pollFirst();
        System.out.println(linkedList.peekFirst());
    }
}
