package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

public class ParseLispExpression {
    Map<String, Deque<Integer>> map = new HashMap<>();
    int idx = 0;

    public int evaluate(String expression) {
        //a, b1, 12, -12...
        if (expression.charAt(idx) != '(') {
            if (Character.isLowerCase(expression.charAt(idx))) {
                String var = parseVar(expression);
                return map.get(var).peek();
            } else {
                return parseInt(expression);
            }
        }
        //let, add, multi
        int res = 0;
        idx++;
        if (expression.charAt(idx) == 'l') {
            idx += 4;
            List<String> vars = new ArrayList<>();
            while (true) {
                //(let ... -12)
                //(let ... (add ...))
                if (!Character.isLowerCase(expression.charAt(idx))) {
                    res = evaluate(expression);
                    break;
                }
                String var = parseVar(expression);
                //(let ... a)
                if (expression.charAt(idx) == ')') {
                    res = map.get(var).peek();
                    break;
                }
                idx++;
                int value = evaluate(expression);
                idx++;
                vars.add(var);
                map.putIfAbsent(var, new ArrayDeque<>());
                map.get(var).push(value);
            }
            for (String var : vars) {
                map.get(var).pop();
            }
        } else if (expression.charAt(idx) == 'a') {
            idx += 4;
            int d1 = evaluate(expression);
            idx++;
            int d2 = evaluate(expression);
            res = d1 + d2;
        } else {
            idx += 5;
            int d1 = evaluate(expression);
            idx++;
            int d2 = evaluate(expression);
            res = d1 * d2;
        }
        idx++;
        return res;
    }

    String parseVar(String expression) {
        StringBuilder sb = new StringBuilder();
        while (Character.isLowerCase(expression.charAt(idx)) || Character.isDigit(expression.charAt(idx))) {
            sb.append(expression.charAt(idx));
            idx++;
        }
        return sb.toString();
    }

    int parseInt(String expression) {
        int res = 0;
        int sign = 1;
        if (expression.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        while (Character.isDigit(expression.charAt(idx))) {
            res = res * 10 + (expression.charAt(idx) - '0');
            idx++;
        }
        return sign * res;
    }
    
    @ParameterizedTest
    @CsvSource({"(let x 2 (mult x (let x 3 y 4 (add x y)))), 14",
            "(let x 3 x 2 x), 2",
            "(let x 1 y 2 x (add x y) (add x y)), 5",
            "(let a1 3 b2 (add a1 1) b2), 4",
            "(let x 7 -12), -12"})
    void test(String expression, int expected) {
        Assertions.assertEquals(expected, evaluate(expression));
    }
}
