package pl.coderslab;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2 {

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });



        queue.add(1);
        queue.add(34);
        queue.add(5);
        queue.add(-10);


        for (int i = 0; i < 4; i++) {
            System.out.println("Element " + i + " " + queue.remove());
        }

    }
}
