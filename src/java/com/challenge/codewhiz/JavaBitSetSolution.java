package com.challenge.codewhiz;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSetSolution {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        int n = st.nextInt();
        int m = st.nextInt();
        BitSet bitSet1 = new BitSet(n);
        BitSet bitSet2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String operation = st.next();
            int operator1 = st.nextInt();
            int operator2 = st.nextInt();
            performOperation(bitSet1, bitSet2, operation, operator1, operator2);
            printSetBits(bitSet1);
            System.out.print(" ");
            printSetBits(bitSet2);
            System.out.println("");
        }
    }

    private static void performOperation(BitSet bitSet1, BitSet bitSet2, String operation, int operator1, int operator2) {
        switch (operation) {
            case "AND":
                if (operator1 == 1) {
                    bitSet1.and(bitSet2);
                } else {
                    bitSet2.and(bitSet1);
                }
                break;
            case "OR":
                if (operator1 == 1) {
                    bitSet1.or(bitSet2);
                } else {
                    bitSet2.or(bitSet1);
                }
                break;
            case "XOR":
                if (operator1 == 1) {
                    bitSet1.xor(bitSet2);
                } else {
                    bitSet2.xor(bitSet1);
                }
                break;
            case "FLIP":
                if (operator1 == 1) {
                    bitSet1.flip(operator2);
                } else {
                    bitSet2.flip(operator2);
                }
                break;
            case "SET":
                if (operator1 == 1) {
                    bitSet1.set(operator2);
                } else {
                    bitSet2.set(operator2);
                }
                break;
        }
    }

    private static void printSetBits(BitSet bitSet) {
        int numberOfSetBits = 0;
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            numberOfSetBits++;
        }
        System.out.print(numberOfSetBits);
    }
}