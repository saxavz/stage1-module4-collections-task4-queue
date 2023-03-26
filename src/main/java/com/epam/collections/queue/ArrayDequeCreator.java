package com.epam.collections.queue;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> commonDeck = new ArrayDeque<>();

//        First, both take turns adding two cards to the ArrayDeque<Integer>.
        moveCards(firstQueue, commonDeck, 2);
        moveCards(secondQueue, commonDeck, 2);

//        Then, with each move, the player:
        while(areQueuesEmpty(firstQueue,secondQueue) == false) { //The moves go until the both players' Queue<Integer> of cards are not empty.
            makePlayerTurn(firstQueue, commonDeck);
            makePlayerTurn(secondQueue, commonDeck);
        }
        System.out.println(commonDeck);
        return commonDeck;
    }

    private void makePlayerTurn(Queue<Integer> playerQ, ArrayDeque<Integer> commonDeck){
//        - takes the top card [top == recently added] from the ArrayDeque<Integer> and adds this card to the end (make it last) of his Queue<Integer>
        playerQ.add( commonDeck.pollLast());
//        - puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>.
        moveCards(playerQ, commonDeck, 2);
    }

    public static boolean areQueuesEmpty(Queue q1, Queue q2){
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void moveCards(Queue<Integer> from, Queue<Integer> to, final int numberCardsToMove){
        int i = 0;
        while(i < numberCardsToMove && from.size() > 0){
            Integer tmp = from.poll();
            if(tmp != null){
                to.add(tmp);
            }
            ++i;
        }
    }
}
