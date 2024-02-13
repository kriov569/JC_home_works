package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

//      Задание 2: Реализуй метод, в котором создаются ArrayList, LinkedList и
//      заполняются 1 000 000 случайными элементами одного и того же типа. После из ArrayList и LinkedList
//      1000 раз выбираем элемент по случайному индексу. Замерь время для ArrayList и LinkedList.
//      Сравни результаты и предположи, почему они могут отличаться.

public class LinkLsAndArrList {
    public static void compareAccessTime() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer>linkedList = new LinkedList<>();
        Random random = new Random();

        // Заполнение ArrayList и LinkedList 1 000 000 случайными элементами

        for (int i = 0; i < 1000000; i++) {
            int randomNumber = random.nextInt(1000000);
            arrayList.add(randomNumber);
            linkedList.add(randomNumber);
        }

        // Замер времени доступа к элементам LinkedList

        long arrayListStartTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(arrayList.size());
            int element = arrayList.get(randomIndex);
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListTime = arrayListEndTime - arrayListStartTime;

        // Замер времени доступа к элементам LinkedList
        long linkedListStartTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(linkedList.size());
            int element = linkedList.get(randomIndex);
        }
        long linkedListEndTime = System.nanoTime();
        long linkedListTime = linkedListEndTime - linkedListStartTime;

        System.out.println("ArrayList access time: " + arrayListTime + " nanoseconds");
        System.out.println("LinkedList access time: " + linkedListTime + " nanoseconds");
    }

    public static void main(String[] args) {
        compareAccessTime();
    }
}
// Доступ к элементам в LinkedList медленее, так как требуется последовательное прохождение
// от начала или конца списка до нужного элементам