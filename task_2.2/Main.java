/*Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
... */
public class Main {

    public static void main(String[] args) {
            for(int x = 1; x < 11; x++){
                for(int y = 1; y < 11; y++){
                    System.out.print(x * y + "  ");
                }
                System.out.println("");
            }
    }
}