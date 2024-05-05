package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        var res = new ArrayDeque<Integer>();
        res.add(firstQueue.remove());
        res.addLast(firstQueue.remove());
        res.addLast(secondQueue.remove());
        res.addLast(secondQueue.remove());

        while (!firstQueue.isEmpty()) {
            firstQueue.add(res.removeLast());
            res.addLast(firstQueue.remove());
            res.addLast(firstQueue.remove());
            secondQueue.add(res.removeLast());
            res.addLast(secondQueue.remove());
            res.addLast(secondQueue.remove());
        }
        return res;
    }
}
