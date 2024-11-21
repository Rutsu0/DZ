import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите А=");
        double A = in.nextDouble();
        System.out.print("Введите B=");
        double B = in.nextDouble();
        System.out.print("Введите H=");
        double H = in.nextDouble();

        double x = floor(A * 100.0) / 100.0;
        double y;
        do {
            if (cos(x/2) == 0 || x == 0)
                System.out.printf("при х=%.1f В знаменателе недопустимое значение\n", x);
            else {
                y = (1/x)*(sin(x/2)/cos(x/2));
                System.out.printf("при х=%.1f y=%.3f\n", x, y);
            }
            x = x + H;
        }
        while (x <= B);
    }
}


