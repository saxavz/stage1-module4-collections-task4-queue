package com.epam.collections.queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {

        PriorityQueue<String> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(firstList);
        q.addAll(secondList);
        return q;
    }
}
