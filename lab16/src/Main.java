import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[][] N = new int[10][9];
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 9; j++)
                N[i][j] = r.nextInt(-50, 50);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++)
                System.out.printf("%-6d", N[i][j]);
            System.out.println();
        }

        // 1) Найти среднее арифметическое значение всех элементов матрицы.
        int min = Integer.MAX_VALUE;
        int S1 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                S1 += N[i][j];
                if (N[i][j] < min){
                    min = N[i][j];
                }
            }
        }
        System.out.println("Среднее арифметическое: " + (S1 / (10 * 9)));

        //2) Вычислить количество элементов в 6-й строке, равных минимальному элементу матрицы
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (N[5][i] == min){
                count++;
            }
        }
        System.out.println(count);

        //3) Сформировать одномерный массив R из сумм элементов каждого столбца матрицы.
        int[] R = new int[9];
        int P;
        for (int j = 0; j < 9; j++) {
            P = 0;
            for (int i = 0; i < 10; i++) {
                P += N[i][j];
            }
            R[j] = P;
        }
        System.out.println(Arrays.toString(R));

        //4) Сформировать одномерный массив S из элементов матрицы, меньших N42
        int value = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (N[i][j] < N[4][2]){
                    value++;
                }
            }
        }

        int[] S = new int[value];
        value = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (N[i][j] < N[4][2]){
                    S[value] = N[i][j];
                    value++;
                }
            }
        }
        System.out.println(Arrays.toString(S));
    }
}
