package Stack;

import java.util.*;

public class BasicCalculatorIV {


    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], String.valueOf(evalints[i]));
        }
        return evalRPN(parse(expression, map)).toList();
    }

    List<String> parse(String expression, Map<String, String> map) {
        List<String> rpn = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == ' ') {
                i++;
            } else if (Character.isLetterOrDigit(expression.charAt(i))) {
                int j = i + 1;
                while (j < expression.length() && Character.isLetterOrDigit(expression.charAt(j))) {
                    j++;
                }
                String str = expression.substring(i, j);
                String var = map.getOrDefault(str, str);
                rpn.add(var);
                i = j;
            } else {
                if (expression.charAt(i) == '(') {
                    stack.push('(');
                } else if (expression.charAt(i) == ')') {
                    while (stack.peek() != '(') {
                        rpn.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && stack.peek() != '(' && higher(stack.peek(), expression.charAt(i))) {
                        rpn.add(String.valueOf(stack.pop()));
                    }
                    stack.push(expression.charAt(i));
                }
                i++;
            }
        }
        while (!stack.isEmpty()) {
            rpn.add(String.valueOf(stack.pop()));
        }
        return rpn;
    }

    boolean higher(Character a, Character b) {
        return a == '*' || a == '/' || (b != '*' && b != '/');
    }

    EXP evalRPN(List<String> rpn) {
        Deque<EXP> stack = new ArrayDeque<>();
        for (String str : rpn) {
            if (Character.isLetterOrDigit(str.charAt(str.length() - 1))) {
                stack.push(new EXP(str));
            } else {
                EXP e2 = stack.pop();
                EXP e1 = stack.pop();
                EXP e3 = new EXP();
                switch (str) {
                    case "+" -> {
                        e3 = e1.add(e2, 1);
                    }
                    case "-" -> {
                        e3 = e1.add(e2, -1);
                    }
                    case "*" -> {
                        e3 = e1.multi(e2);
                    }
                }
                stack.push(e3);
            }
        }
        return stack.pop();
    }

    class EXP {
        Map<List<String>, Integer> e;

        public EXP() {
            e = new HashMap<>();
        }

        public EXP(String str) {
            e = new HashMap<>();
            List<String> key = new ArrayList<>();
            if (Character.isLetter(str.charAt(0))) {
                key.add(str);
                e.put(key, 1);
            } else {
                e.put(key, Integer.parseInt(str));
            }
        }

        public EXP(Map<List<String>, Integer> _e) {
            e = _e;
        }

        EXP add(EXP exp2, int sign) {
            Map<List<String>, Integer> e3 = new HashMap<>(e);
            for (List<String> k2 : exp2.e.keySet()) {
                e3.put(k2, e3.getOrDefault(k2, 0) + sign * exp2.e.get(k2));
            }
            return new EXP(e3);
        }

        public EXP multi(EXP exp2) {
            Map<List<String>, Integer> e3 = new HashMap<>();
            for (List<String> k1 : e.keySet()) {
                for (List<String> k2 : exp2.e.keySet()) {
                    List<String> key = new ArrayList<>();
                    key.addAll(k1);
                    key.addAll(k2);
                    Collections.sort(key);
                    e3.put(key, e3.getOrDefault(key, 0) + e.get(k1) * exp2.e.get(k2));
                }
            }
            return new EXP(e3);
        }

        List<String> toList() {
            List<List<String>> keys = new ArrayList<>(e.keySet());
            keys.sort((a, b) -> {
                if (a.size() == b.size()) {
                    return a.toString().compareTo(b.toString());
                } else {
                    return b.size() - a.size();
                }
            });
            List<String> list = new ArrayList<>();
            for (List<String> key : keys) {
                if (e.get(key) == 0) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(e.get(key));
                for (String var : key) {
                    sb.append("*").append(var);
                }
                list.add(sb.toString());
            }
            return list;
        }
    }
}

//思路和算法
//        这道题要求根据给定的映射将给定的整式化简并以列表的形式返回。为了将整式化简，可以首先将整式转换成逆波兰表达式，然后利用「150. 逆波兰表达式求值」的解法化简整式。
//
//        将整式转换成逆波兰表达式，需要分别遍历整式中的每个元素，每个元素可以是变量、非负整数或符号（符号包括四则运算符号和括号），使用栈存储符号完成转换。由于题目给定的整式已经将各项用空格分隔，只有括号和变量或非负整数相连，因此只要对括号做处理，即可将整式中的每个元素分离。对于每种类型的元素，执行如下操作。
//
//        如果元素是变量或整数，则将元素添加到逆波兰表达式。为了方便处理，对于每个变量判断其是否在映射中存在，如果存在则将变量替换成对应的整数。
//
//        如果元素是左括号，则将元素入栈。
//
//        如果元素是右括号，则将栈内元素依次出栈并按出栈顺序添加到逆波兰表达式，直到栈顶元素是左括号，然后将左括号出栈。
//
//        如果元素是四则运算符号，则当栈不为空且栈顶符号的优先级大于等于当前符号的优先级时，将栈顶符号出栈并按出栈顺序添加到逆波兰表达式，直到栈为空或栈顶符号的优先级小于当前符号的优先级，然后将当前符号入栈。
//
//        栈内的符号优先级为：乘号的优先级最高，加号和减号的优先级其次，左括号的优先级最低。实现方面，将乘号的优先级设为
//        2
//        2，加号和减号的优先级设为
//        1
//        1，左括号的优先级设为
//        0
//        0。
//
//        遍历结束之后，如果栈不为空，则将栈内元素依次出栈并按出栈顺序添加到逆波兰表达式。当栈变为空时，即可得到完整的逆波兰表达式。
//
//        计算逆波兰表达式的值，需要使用栈存储操作数，操作数包括变量和整数，从左到右遍历并计算。具体操作如下。
//
//        如果遇到操作数，则将操作数入栈。
//
//        如果遇到运算符，则将两个操作数出栈，其中先出栈的是第二个操作数，后出栈的是第一个操作数，使用运算符对两个操作数运算，得到新操作数，将新操作数入栈。
//
//        遍历结束之后，栈内只有一个元素，该元素为逆波兰表达式的值，即化简后的整式。
//
//        实现
//        实现方面，为了能统一处理变量和整数，以及加法、减法和乘法的运算，需要创建一个表达式类用于存储表达式。表达式类的成员为哈希表，哈希表中的每个键值对表示一个单项式或常数项，其中关键字为单项式的变量列表（如果列表为空则表示常数项），值为单项式的前导系数。
//
//        初始时，每一个变量或字母分别是一个表达式。计算两个表达式的加法、减法和乘法时，需要模拟整式的加法、减法和乘法，两个表达式运算的效果是使用一个新的表达式替代原有的两个表达式。当剩余一个表达式时，化简结束。
//
//        化简之后，将结果表达式以列表的形式返回，需要确保返回的列表符合输出格式的要求。