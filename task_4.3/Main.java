/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {


    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int cat1win = 0;
        int cat2win = 0;
        if (this.age == anotherCat.age) {
            cat1win++;
        } else {
            if (this.age > anotherCat.age)
                cat1win++;
            else cat2win++;
        }
        if (this.weight == anotherCat.weight) {
            cat1win++;
        } else {
            if (this.weight > anotherCat.weight)
                cat1win++;
            else cat2win++;
        }
        if (this.strength == anotherCat.strength) {
            cat1win++;
        } else {
            if (this.strength > anotherCat.strength)
                cat1win++;
            else cat2win++;
        }
        if (cat1win > cat2win)
            return true;
        else return false;
    }
}

