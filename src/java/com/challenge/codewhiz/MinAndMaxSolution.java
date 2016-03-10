package com.challenge.codewhiz;

import java.util.Arrays;
import java.util.Scanner;

public class MinAndMaxSolution {

    public static void print(int A[], int i) {
        try {
            System.out.println(A[i]);
        } catch (Exception e) {
            printMinAndMax(A);
            throw e;
        }
        printMinAndMax(A);
    }

    private static void printMinAndMax(int[] A) {
        Arrays.sort(A);
        System.out.println(A[A.length - 1] + " " + A[0]);
    }

    public static void main(String[] args) {
        int N;
        Scanner st = new Scanner(System.in);
        N = st.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = st.nextInt();
        }
        int i = st.nextInt();
        try {
            print(A, i);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}



