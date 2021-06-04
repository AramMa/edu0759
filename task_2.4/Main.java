/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите сумму вклада: ");
        int a = scan.nextInt();
        System.out.print("Введите процент: ");
        int b = scan.nextInt();
        int x = a * b;
        for (int y = 0; y < 5; y++) {
            System.out.println("Ежегодный доход: " + x * 0.01);
        }
    }
}
