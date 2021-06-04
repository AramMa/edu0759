/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int [] numbers = {2,0,5,-148,70};
        int value = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 5) value = 5;
        } if (value == 5) System.out.println("Да");
        else System.out.println("Нет");
    }
}
