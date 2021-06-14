  
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Z://project/edu_0759/task_5.4/test.txt");
            int i;
            List<String> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            String j = "";
            while ((i = fis.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    list.add(j);
                    j = "";
                }else if (i != 9) {
                    j += (char) i;
                }
            }
            list.add("13"); // я не понимаю почему на 51 строке всегда удаляется последний элемент массива и добавил костыль.
            for(String s : list) list2.add(Integer.valueOf(s));
            for (int z = 0; z < list2.size();) {
                    if (list2.get(z) % 2 != 0){
                        list2.remove(z);
                }else z++;
            }
            Collections.sort(list2);
            System.out.print(list2);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

