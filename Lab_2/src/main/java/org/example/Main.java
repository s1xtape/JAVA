package org.example;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        menu(new Main());
    }
    public static void menu(Main app){
        Scanner scaners = new Scanner(System.in);
        System.out.println("Enter the width of the matrix but not more than 20:");
        int width = scaners.nextInt();
        System.out.println("Enter the height of the matrix but not more than 20:");
        int height = scaners.nextInt();
        int[][] matrix = new int[width][height];
        System.out.println("1. Manual filling");
        System.out.println("2. Random filling");
        int num = scaners.nextInt();
        switch (num) {
            case 1: {
                app.SetMatrixMySelf(matrix);
                break;
            }
            case 2:{
                app.SetMatrixRandom(matrix);
                break;
            }
        }

    }
    public void SetMatrixMySelf(int[][] matrix){
        Scanner scaners = new Scanner(System.in);
        for(int i = 0 ; i< matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                System.out.println("Input element " + (i+1) + " " + (j+1) +": ");
                matrix[i][j]=scaners.nextInt();
            }
        }
        for(int i = 0 ; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("\n");
        }
        Calculation(matrix);
    }
    public void SetMatrixRandom(int[][] matrix){
        Random random = new Random();
        Scanner scaners = new Scanner(System.in);
        System.out.println("Enter the number from which to randomize:");
        int width = scaners.nextInt();
        System.out.println("Enter the number to which it will randomize:");
        int height = scaners.nextInt();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = random.nextInt(width,height);
            }
        }
        for(int i = 0 ; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("\n");
        }
        Calculation(matrix);
    }
    public void Calculation(int[][] matrix){
        int max=matrix[0][0];
        int min=matrix[0][0];
        float suma = 0;
        float kol = 0;
        for(int i = 0 ; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(max<matrix[i][j]){
                    max = matrix[i][j];
                }
                if(min>matrix[i][j]){
                    min = matrix[i][j];
                }
                suma+=matrix[i][j];
                kol++;
            }
        }
        float ser = suma/kol;
        System.out.println("Max element: " + max);
        System.out.println("Min element: " + min);
        System.out.println("Ser elements: " + ser);
    }
}