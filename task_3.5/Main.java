/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        int i = 0;
        numbers(num, i);
    }
    public static void numbers(int[] num, int i) {
        if (i < 5){
            System.out.println(num[i]);
            numbers(num, i + 1);
        }else System.out.println("Конец");
    }
}
