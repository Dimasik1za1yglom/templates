package main;

import main.entity.entityCollect.Person;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class MainCollect {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Dima", 22),
                new Person("Igor", 25),
                new Person("Andrey", 22),
                new Person("Sacha", 18),
                new Person("Ira", 18)
        );

//        List<Person> filtered = persons.stream()
//                .filter(person -> person.getName().startsWith("I"))
//                .collect(Collectors.toList());
//        System.out.println(filtered);

//        Map<Integer, List<Person>> personByAge = persons.stream()
//                .collect(Collectors.groupingBy(Person::getAge));
//        personByAge.forEach((age, p) -> System.out.printf("age %s: %s\n", age, p));
//
//        Double averageAge = persons.stream()
//                .collect(Collectors.averagingInt(Person::getAge));
//        System.out.println(averageAge);

//        IntSummaryStatistics ageSummary = persons.stream()
//                .collect(Collectors.summarizingInt(Person::getAge));
//        System.out.println(ageSummary);

//        String phrase = persons.stream()
//                .filter(person -> person.getAge() >= 18)
//                .map(Person::getName)
//                .collect(Collectors.joining(" и ","В России ", " совершенолетние. "));
//        System.out.println(phrase);

//        Map<Integer, String> map = persons.stream()
//                .collect(Collectors.toMap(
//                        Person::getAge,
//                        Person::getName,
//                        (name1, name2) -> name1 + ";" + name2
//                ));
//        System.out.println(map);

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),      //supplier
                        (j, p) -> j.add(p.getName().toUpperCase()), //accumulator
                        StringJoiner::merge,                        //combiner
                        StringJoiner::toString                      //finisher
                );
        String name = persons.stream()
                .collect(personNameCollector);
        System.out.println(name);
    }
}
