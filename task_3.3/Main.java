/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        Scanner scan2 = new Scanner(System.in);
        int b = scan2.nextInt();
        if (number(a, b) == a) System.out.println("true");
        else System.out.println("false");
    }
    public static int number(int a, int b) {
        if (a == b) return a;
        else return b;
    }
}