package ZuoChengyun.Basic.Day08;

public class Happiness {
    static class Employee {
        int happiness;
        Employee[] list;

        public Employee(int happiness, Employee[] list) {
            this.happiness = happiness;
            this.list = list;
        }
    }

    static class Info {
        int yes, no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static Info invite(Employee root) {
        int yes = root.happiness;
        int no = 0;
        for (Employee employee : root.list) {
            Info info = invite(employee);
            yes += info.no;
            no += Math.max(info.no, info.yes);
        }
        return new Info(yes, no);
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(1, new Employee[]{});
        Employee e5 = new Employee(5, new Employee[]{});
        Employee e4 = new Employee(4, new Employee[]{e1, e5});
        Employee e7 = new Employee(7, new Employee[]{});
        Employee e2 = new Employee(2, new Employee[]{e4, e7});


        Info info = invite(e2);
        System.out.println(info.no + " - " + info.yes);
    }
}
