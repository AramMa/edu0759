/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int [] numbers = {44,0,-5,148,148,70};
        boolean test = false;
        for (int i = 0; i < numbers.length; i++){
            for (int j =0; j< numbers.length; j++){
                if (i != j && numbers[i] == numbers[j]) test = true;
            }
        } if (test == true) System.out.println("Да");
        else System.out.println("Нет");
    }
}
