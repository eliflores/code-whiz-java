package com.challenge.codewhiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface performOperation {
    int check(int a);
}

class Math {
    public static int checker(performOperation p, int num) {
        return p.check(num);
    }

    public performOperation checkEvenOdd() {
        return num -> num % 2 == 0 ? 0 : 1;
    }

    public performOperation checkPrime() {
        return num -> {
            int temp;
            for (int i = 2; i <= num / 2; i++) {
                temp = num % i;
                if (temp == 0) {
                    return 1;
                }
            }
            return 0;
        };
    }

    public performOperation checkPalindrome() {
        return num -> {
            String numString = String.valueOf(num);
            String reversedString = new StringBuilder(numString).reverse().toString();
            return numString.compareTo(reversedString) == 0 ? 0 : 1;
        };
    }
}

public class LambdaExpressionsSolution {

    public static void main(String[] args) throws IOException {
        Math ob = new Math();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        performOperation op;
        int ret;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.checkEvenOdd();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "EVEN" : "ODD";
            } else if (ch == 2) {
                op = ob.checkPrime();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.checkPalindrome();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
