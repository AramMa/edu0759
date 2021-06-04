/*
Задание: Даны переменные a и b. Проверьте, что a делится без остатка на b. Если это так - выведите 'Делится' и результат деления, иначе выведите 'Делится с остатком' и остаток от деления.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите a: ");
        int a = scan.nextInt();
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Введите b: ");
        int b = scan2.nextInt();
        if (a % b == 0){
            System.out.println("Делится");
        }else
        System.out.println("Делится с остатком: " + a % b);
    }
}
