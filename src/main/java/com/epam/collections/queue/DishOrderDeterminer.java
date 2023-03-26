package com.epam.collections.queue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {

        final Queue<Integer> dishes = initDishes(numberOfDishes);
        final List<Integer> res = new ArrayList<>();

        IntStream.iterate(1, i -> dishes.isEmpty() == false, i -> i+1 )
                .forEach( i -> {
                                int pulled = dishes.poll();
                                if(hasToBeEaten(i, everyDishNumberToEat)){
                                    res.add(pulled);
                                } else {
                                    dishes.add(pulled);
                                }
                                });
        return res;
    }

    public static Queue<Integer> initDishes(int numberOfDishes){
        return IntStream.rangeClosed(1,numberOfDishes)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public  boolean hasToBeEaten(int dishPos, int everyDishNumberToEat){
        return  dishPos % everyDishNumberToEat == 0;
    }
}
