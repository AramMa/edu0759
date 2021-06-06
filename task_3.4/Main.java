/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        Scanner scan2 = new Scanner(System.in);
        int b = scan2.nextInt();
        if (number(a, b) == 1) System.out.println("true");
        else System.out.println("false");
    }
    public static int number(int a, int b) {
        if (a + b > 10) return 1;
        else return 0;
    }
}
