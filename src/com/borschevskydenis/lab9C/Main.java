package com.borschevskydenis.lab9C;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("temp.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int n=0;
        while (bufferedReader.ready()){
            bufferedReader.readLine();
            n++;
        }
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            String[] str =  bufferedReader1.readLine().split("\\s");
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        bufferedReader1.close();

        System.out.println("Начальная матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("Транспонированная матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
