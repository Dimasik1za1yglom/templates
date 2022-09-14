package main;

import main.singleton.SingletonThree;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SingletonThree singletonThree = SingletonThree.INSTANCE;
    }
}
