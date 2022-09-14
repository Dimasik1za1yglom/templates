package main.singleton;

import java.io.Serial;
import java.io.Serializable;

//Синглетон со статической фабрикой
public class SingletonTwo implements Serializable {

    //transient для сериализации
    transient private final String name;

    transient private static final SingletonTwo INSTANCE = new SingletonTwo();

    private SingletonTwo() {
        this.name = "Dima";
    }

    public static SingletonTwo getInstance(){
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    //для сериализации
    @Serial
    private Object readResolve(){
        return INSTANCE;
    }
}
