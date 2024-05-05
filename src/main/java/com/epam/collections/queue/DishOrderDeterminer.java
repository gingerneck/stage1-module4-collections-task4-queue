package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        var res = new LinkedList<Integer>();
        var dishes =
                IntStream.rangeClosed(1, numberOfDishes).boxed()
                        .collect(Collectors.toCollection(LinkedList::new));
        everyDishNumberToEat = everyDishNumberToEat - 1;
        var index = everyDishNumberToEat;
        while (dishes.size() != 0) {

            res.add(dishes.remove(index));
            index = index + everyDishNumberToEat;
            if (index >= dishes.size()) {
                index = index - dishes.size();
            }
            if (dishes.size() == 1) {
                res.add(dishes.remove());
            }
        }
        return res;
    }
}
