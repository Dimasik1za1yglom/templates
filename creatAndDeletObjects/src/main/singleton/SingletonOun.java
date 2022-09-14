package main.singleton;

import java.io.Serial;
import java.io.Serializable;

//Синглтон с полем public final
public class SingletonOun implements Serializable {

    //transient для сериализации
    transient private final String name;

    transient public static final SingletonOun INSTANCE = new SingletonOun();

    private SingletonOun() {
        this.name = "Dima";
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
