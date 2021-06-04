/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int [] numbers = {2,-3,0,7,1,4,-5,17};
        int value = 0;
        int result = 0;
        for (int i = 0; value < 10; i++){
            value = value + numbers[i];
            result = 1 + i;
        }
        System.out.println("Количество элементов, которые нужно сложить: " + result);
    }
}
