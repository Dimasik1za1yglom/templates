package main;

import main.entity.entityOptional.Outer;

import java.util.Optional;

public class MainOptional {
    public static void main(String[] args) {
//        Outer outer = new Outer();
//        if (outer != null && outer.getNested() != null && outer.getNested().getInner() != null) {
//            System.out.println(outer.getNested().getInner().getFoo());
//        }

        Optional.of(new Outer())
                .flatMap(outer -> Optional.ofNullable(outer.getNested()))
                .flatMap(nested -> Optional.ofNullable(nested.getInner()))
                .flatMap(inner -> Optional.ofNullable(inner.getFoo()))
                .ifPresent(System.out::println);
    }
}
