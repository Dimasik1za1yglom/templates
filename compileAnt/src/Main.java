import entity.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Введите ваш возраст:");
        Integer age = scanner.nextInt();
        Person person = new Person(name, age);
        System.out.println(person.getDocumentation());
    }
}
