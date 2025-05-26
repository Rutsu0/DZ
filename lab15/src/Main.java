import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //№1

        /*
        int M = in.nextInt();
        int N = in.nextInt();
        int K1 = in.nextInt();
        int K2 = in.nextInt();
        int [][] B = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = in.nextInt();
            }
        }
        int T;
        for (int i = 0; i < M; i++) {
            T = B[i][K1 - 1];
            B[i][K1 - 1] = B[i][K2 - 1];
            B[i][K2 - 1] = T;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(B[i][j]);
            }
        }*/

        //№2

        /*
        int M = in.nextInt();
        int N = in.nextInt();
        int [][] B = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            int min = 0;
            int max = 0;
            for (int j = 1; j <M; j++) {
                if (B[j][i] < B[min][i]){
                    min = j;
                }
                if (B[j][i] > B[max][i]){
                    max = j;
                }
                int T = B[min][i];
                B[min][i] = B[max][i];
                B[max][i] = T;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(B[i][j]+ " ");
            }
            System.out.println();
        }
         */
    }
}