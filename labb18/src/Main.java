import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] d={1000, 10000, 100000, 250000, 350000, 450000};
        Random r=new Random();
        int [] arr;
        for (int i = 0; i < 6; i++) {
            arr=new int[d[i]];
            for (int j = 0; j < d[i]; j++) {
                arr[j]=r.nextInt(-1000, 1000);
            }
            System.out.println(d[i]+" элеметов:");
            Set(arr);
        }
    }

    private static void Set(int[] arr) {
        System.out.print("Пузырьком: ");
        Instant start=Instant.now();
        Booble(arr);
        Instant end=Instant.now();
        Duration dist=Duration.between(start, end);
        System.out.println( dist.toMillis()+"мс");


        System.out.print("выбором:");
        start=Instant.now();
        Select(arr);
        end=Instant.now();
        dist=Duration.between(start, end);
        System.out.println(dist.toMillis()+"мс");


        System.out.print("вставками: ");
        start=Instant.now();
        insertion(arr);
        end=Instant.now();
        dist=Duration.between(start, end);
        System.out.println(dist.toMillis()+"мс");

        System.out.print("Шелла: ");
        start=Instant.now();
        Shell(arr);
        end=Instant.now();
        dist=Duration.between(start, end);
        System.out.println( dist.toMillis()+"мс");
    }

    private static void Booble(int[] arr) {
        int[]a= Arrays.copyOf(arr,arr.length);
        int T=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-2; j >=i; j--) {
                if (a[j]>=a[j+1]){
                    T=a[j];
                    a[j]=a[j+1];
                    a[j+1]=T;
                }
            }
        }
    }

    private static void insertion(int[] arr) {
        int[]a= Arrays.copyOf(arr,arr.length);
        int z;
        for (int i = 1; i < a.length; i++) {
            z=a[i];
            int j;
            for (j = i-1; j >=0 && a[j]>z; j--) {
                a[j+1]=a[j];
            }
            a[j+1]=z;
        }
    }

    private static void Select(int[] arr) {
        int[]a= Arrays.copyOf(arr,arr.length);
        for (int i = 0; i < a.length-1; i++) {
            int min=a[i];
            int iMin=i;
            for (int j = i+1; j < a.length; j++) {
                if (min>a[j]){
                    min=a[j];
                    iMin=j;
                }
            }
            a[iMin]=a[i];
            a[i]=min;
        }
    }
    private static void Shell(int[] arr) {
        int[] a= Arrays.copyOf(arr,arr.length);
        int z;
        for (int d = a.length / 2; d > 0; d = d / 2) {
            for (int i = d; i < a.length; i++) {
                for (int j = i-d; j >= 0 && a[j] > a[j + d]; j -= d) {
                    z = a[j];
                    a[j] = a[j + d];
                    a[j + d] = z;
                }
            }
        }
    }
}

//1000 элеметов:
//Пузырьком: 5мс
//выбором:3мс
//вставками: 2мс
//Шелла: 0мс
//10000 элеметов:
//Пузырьком: 143мс
//выбором:38мс
//вставками: 22мс
//Шелла: 2мс
//100000 элеметов:
//Пузырьком: 8850мс
//выбором:1259мс
//вставками: 3127мс
//Шелла: 20мс
//250000 элеметов:
//Пузырьком: 52844мс
//выбором:8039мс
//вставками: 6591мс
//Шелла: 40мс
//350000 элеметов:
//Пузырьком: 100121мс
//выбором:15937мс
//вставками: 12934мс
//Шелла: 52мс
//450000 элеметов:
//Пузырьком: 165864мс
//выбором:26406мс
//вставками: 21770мс
//Шелла: 72мс