package Leetcode.Coding_Interview_6.C16;

public class S08 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder str = new StringBuilder();
        for (int i = 3, j = 1000000000; j > 0; i--, j /= 1000) {
            StringBuilder sb = new StringBuilder();
            int curr = num / j;
            if (curr != 0) {
                f(curr, sb);
                sb.append(thousands[i]).append(" ");
            }
            str.append(sb);
            num %= j;
        }
        return str.toString().trim();

    }

    void f(int n, StringBuilder sb) {
        if (n == 0) return;
        if (n < 10) {
            sb.append(singles[n]).append(" ");
        } else if (n < 20) {
            sb.append(teens[n - 10]).append(" ");
        } else if (n < 100) {
            sb.append(tens[n / 10]).append(" ");
            f(n % 10, sb);
        } else {
            sb.append(singles[n / 100]).append(" ").append("Hundred").append(" ");
            f(n % 100, sb);
        }
    }


}

