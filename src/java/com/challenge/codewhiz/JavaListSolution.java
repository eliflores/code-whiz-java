package com.challenge.codewhiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaListSolution {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        int n = st.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(st.nextInt());
        }

        int q = st.nextInt();
        for (int i = 0; i < q; i++) {
            String operation = st.next();
            int x = st.nextInt();
            if ("Insert".equals(operation)) {
                int y = st.nextInt();
                list.add(x, y);
            } else {
                list.remove(x);
            }
        }

        List<String> newList = list.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join(" ", newList));
    }
}
