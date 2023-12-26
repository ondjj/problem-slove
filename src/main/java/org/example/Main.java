package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 9;
        if (n < 2) {
            System.out.println("2이상 9이하의 정수를 입력해주세요.");
        }else {
            System.out.println("===========================");
            for (int i = start; i <= end; i++) {
                System.out.println(n + " x " + i + " = " + n*i);
            }
            System.out.println("===========================");
        }
    }
}