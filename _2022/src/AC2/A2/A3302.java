package AC2.A2;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class A3302 {
    /*
    “表达式求值”问题，两个核心关键点：
    （1）双栈，一个操作数栈，一个运算符栈；
    （2）运算符优先级，栈顶运算符，和，即将入栈的运算符的优先级比较：
        如果栈顶的运算符优先级低，新运算符直接入栈
        如果栈顶的运算符优先级高或相同，先出栈计算，新运算符再入栈

    遇到左括号直接入栈，遇到右括号持续出栈直到左括号出栈
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        System.out.println(calculate(chars));
    }

    static int calculate(char[] chars) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int t = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                op.push(chars[i]);
            } else if (chars[i] == ')') {
                while (op.peek() != '(') {
                    eval(op, num);
                }
                op.pop();
            } else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                while (!op.isEmpty() && op.peek() != '(' && priority.get(op.peek()) >= priority.get(chars[i])) {
                    eval(op, num);
                }
                op.push(chars[i]);
            } else {
                t = t * 10 + Integer.parseInt(String.valueOf(chars[i]));
                if (i == chars.length - 1 || !Character.isDigit(chars[i + 1])) {
                    num.push(t);
                    t = 0;
                }
            }
        }
        while (!op.isEmpty()) {
            eval(op, num);
        }
        return num.pop();
    }

    static Map<Character, Integer> priority = Map.of('+', 1, '-', 1, '*', 2, '/', 2);

    static void eval(Stack<Character> op, Stack<Integer> num) {
        int b = num.pop();
        int a = num.pop();
        char operator = op.pop();
        int res = 0;
        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
                break;
        }
        num.push(res);
    }
}
