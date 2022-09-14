package main.entity.entityFlatMap;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private String name;

    List<Bar> bars = new ArrayList<>();

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Bar> getBars() {
        return bars;
    }

}
