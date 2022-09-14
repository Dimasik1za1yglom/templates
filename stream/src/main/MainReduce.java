package main;

import main.entity.entityCollect.Person;

import java.util.Arrays;
import java.util.List;

public class MainReduce {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Dima", 22),
                new Person("Igor", 25),
                new Person("Andrey", 22),
                new Person("Sacha", 18),
                new Person("Ira", 18)
        );

//        persons.stream()
//                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
//                .ifPresent(System.out::println);

//        Person result = persons.stream()
//                .reduce(new Person("", 0), (p1, p2) -> {
//                    p1.age += p2.getAge();
//                    p1.name += p2.getName();
//                    return p1;
//                });
//        System.out.printf("name - %s, age - %s", result.name, result.age);

//        Integer ageSum = persons.stream()
//                .reduce(0, (sum, p) -> sum += p.age, Integer::sum);
//        System.out.println(ageSum);

//        Integer ageSum = persons.stream()
//                .reduce(0,
//                        (sum, p) -> {
//                            System.out.printf("accumulator: sum=%s; person=%s\n", sum, p);
//                            return sum += p.age;
//                        },
//                        (sum1, sum2) -> {
//                            System.out.printf("accumulator: sum1=%s; sum2=%s\n", sum1, sum2);
//                            return sum1 + sum2;
//                        });

        Integer ageSum = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.printf("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.printf("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
    }
}
