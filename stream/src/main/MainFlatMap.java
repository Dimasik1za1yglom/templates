package main;

import main.entity.entityFlatMap.Bar;
import main.entity.entityFlatMap.Foo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainFlatMap {
    public static void main(String[] args) {

        List<Foo> foos = new ArrayList<>();
        //create foo
        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        //create bar
        foos.forEach(f -> IntStream.range(1, 4)
                .forEach(i -> f.getBars().add(new Bar("Bar" + i + " <- " + f.getName()))));

        foos.stream()
                .flatMap(f -> f.getBars().stream())
                .forEach(b -> System.out.println(b.getName()));

        //-----------------------------------------
        //Альтернатива
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.getName()))
                        .forEach(f.getBars()::add))
                .flatMap(f -> f.getBars().stream())
                .forEach(b -> System.out.println(b.getName()));
    }
}
