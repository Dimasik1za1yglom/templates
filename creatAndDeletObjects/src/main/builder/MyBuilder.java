package main.builder;

public class MyBuilder {
    private final String name;
    private final int age;
    private final int height;
    private final int weight;
    public static class Builder {

        //Необходимые параметры
        private final String name;
        private final int age;

        //Необязательные параметры
        //Значения по умолчанию
        private int height = 0;
        private int weight = 0;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public MyBuilder build() {
            return new MyBuilder(this);
        }
    }

    private MyBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }
}
