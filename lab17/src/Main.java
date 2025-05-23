import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] P = new int[7][7];
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                P[i][j] = r.nextInt(-5, 15);
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                boolean proverka = false;
                for (int k = 6; k >= 0; k--) {
                    if (i == k && j >= k) {
                        proverka = true;
                        break;
                    }
                }
                if (proverka == true) {
                    System.out.print("\u001B[31m");
                    System.out.printf("%-6d", P[i][j]);
                    System.out.print("\u001B[0m");
                } else {
                    System.out.printf("%-6d", P[i][j]);
                }
            }
            System.out.println();
        }

        //1) Заменить в заштрихованной области матрицы элементы, равные -1, на 30.
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i <= j; i++) {
                if (P[i][j] == -1) {
                    P[i][j] = 30;
                }
            }
        }

        //2) Сформировать одномерный массив R из элементов заштрихованной области матрицы, меньших 6.
        int value = 0;
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i <= j; i++) {
                if (P[i][j] < 6) {
                    value++;
                }
            }
        }

        int[] R = new int[value];
        value = 0;
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i <= j; i++) {
                if (P[i][j] < 6) {
                    R[value] = P[i][j];
                    value++;
                }
            }
        }

        System.out.println(Arrays.toString(R));

        // 3) Сформировать одномерный массив E из количеств элементов равных 8 каждого столбца заштрихованной области
        int[] E = new int[7];
        int s;
        for (int j = 0; j < 7; j++) {
            s = 0;
            for (int i = 0; i <= j; i++) {
                if (P[i][j] == 8) {
                    s++;
                }
            }
            E[j] = s;
        }
        System.out.println(Arrays.toString(E));

        //4) Найти количество отрицательных элементов в левой верхней четверти матрицы.

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i < 3 && j < 3) {
                    System.out.print("\u001B[31m");
                    System.out.printf("%-6d", P[i][j]);
                    System.out.print("\u001B[0m");
                } else {
                    System.out.printf("%-6d", P[i][j]);
                }
            }
            System.out.println();
        }

        int count2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (P[i][j] < 0) {
                    count2++;
                }
            }
        }
        System.out.println(count2);
    }
}
