import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(450000);
        }
        Instant start1 = Instant.now();
        Bubblesort(a);
        Instant end1 = Instant.now();
        Duration dist1 = Duration.between(start1, end1);
        System.out.println("Время " + dist1.toMillis() + " мс");
        Instant start2 = Instant.now();
        Insertsort(a);
        Instant end2 = Instant.now();
        Duration dist2 = Duration.between(start2, end2);
        System.out.println("Время " + dist2.toMillis() + " мс");
        Instant start3 = Instant.now();
        Selectionsort(a);
        Instant end3 = Instant.now();
        Duration dist3 = Duration.between(start3, end3);
        System.out.println("Время " + dist3.toMillis() + " мс");
        Instant start4 = Instant.now();
        Shellsort(a);
        Instant end4 = Instant.now();
        Duration dist4 = Duration.between(start4, end4);
        System.out.println("Время " + dist4.toMillis() + " мс");

    }

    private static void Selectionsort(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;
        }
    }

    private static void Bubblesort(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 2; j >= i; j--) {
                if (a[j] > a[j + 1]) {
                    int T = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = T;
                }
            }
        }
    }

    private static void Insertsort(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            int z = a[i];
            int j;
            for (j = i - 1; a[i] > z && j >= 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = z;
        }
    }

    private static void Shellsort(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        int d = a.length / 2;
        while (d > 0) {
            for (int i = 0; i < a.length - d; i++) {
                int j = i;
                if (j >= 0 && a[j] > a[j + d]) {
                    int z = a[j];
                    a[j] = a[j + d];
                    a[j + d] = z;
                    j = j - d;
                }
            }
            d = d / 2;
        }
    }
}
