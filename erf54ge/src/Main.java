import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Задайте количество элементов x-массива s=");
        int s = in.nextInt();
        float[] x = InputMassiv(s);
        Output(x, "x");
        System.out.println("сумма элементов=" + SummaMassiv(x));

        float[] y = InputMassiv(s);
        Output(y, "y");
        System.out.println("сумма элементов=" + SummaMassiv(y));

        System.out.print("Задайте количество элементов x-массива n=");
        int n = in.nextInt();
        float[] a = InputMassiv(n);
        Output(a, "a");
        System.out.println("сумма элементов=" + SummaMassiv(a));

        float[] b = InputMassiv(n);
        Output(b, "b");
        System.out.println("Cумма элементов=" + SummaMassiv(b));

        float CH = SummaMassiv(x) + SummaMassiv(y) + SummaMassiv(a) + SummaMassiv(b);
        System.out.println("Сумма массивов=" + CH);

        float F = (F_UP(x,y) + Fact(s)) / (F_UP(a,b) - Fact(n));

        System.out.println("F = " + F);
    }
    static float[] InputMassiv(int LengthMassiv) {
        float[] mas = new float[LengthMassiv];
        Random r = new Random();
        for (int i = 0; i < LengthMassiv; i++) {
            mas[i] = (float) r.nextFloat();
        }
        return mas;
    }

    //метод вывода массива на экран
    static void Output(float[] mas, String str) {
        for (int i = 0; i < mas.length; i++) {
            System.out.println(str + "[" + i + "]=" + mas[i]);
        }
    }

    //метод нахождения суммы элементов массива
    static float SummaMassiv(float[] mas) {
        float Sum = 0;
        for (int i = 0; i < mas.length; i++) {
            Sum = Sum + mas[i];
        }
        return Sum;
    }

    static float F_UP(float[] mas1 , float[] mas2) {
        float Sum = 0;
        for (int i = 0; i < mas1.length; i++) {
            Sum += Step(mas1[i] - mas2[i],mas1.length);
        }
        return Sum;
    }


    // метод (функция) Степень
    static float Step(float osn, int nn) {
        float st = 1;
        for (int i = 1; i <= nn; i++) {
            st = st * osn;
        }
        return st;
    }

    // метод (функция) Факториал
    static float Fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}