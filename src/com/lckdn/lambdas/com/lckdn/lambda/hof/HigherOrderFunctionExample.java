package com.lckdn.lambdas.com.lckdn.lambda.hof;

import com.lckdn.lambdas.com.lckdn.lambda.model.RichPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Класс- пример использования функций высших порядков
 */
public class HigherOrderFunctionExample {

    public static void main(String[] args) {
        List<RichPerson> persons = new ArrayList<>();
        persons.add(new RichPerson("Alex", "Black", 25, 50000));
        persons.add(new RichPerson("John", "Green", 35, 75000));
        persons.add(new RichPerson("Sam", "Brown", 40, 80000));
        persons.add(new RichPerson("Tony", "Grey", 50, 90000));

        testPredicate(persons);
        testFunction(persons);
        testConsumer(persons);
    }

    private static void testPredicate(List<RichPerson> persons) {
        System.out.println("Testing predicate...");
        Predicate<RichPerson> isRich = x -> x.getSalary() >= 75000;
        Predicate<RichPerson> isYoung = y -> y.getAge() <= 40;

        // Поиск всех персон по двойному условию (&&)
        System.out.println("Is rich and young");
        findAll(persons, isRich.and(isYoung)).forEach(System.out::println);

        // or
        System.out.println("Is rich or young");
        findAll(persons, isRich.or(isYoung)).forEach(System.out::println);

        // negate
        System.out.println("Is not young");
        findAll(persons, isYoung.negate()).forEach(System.out::println);

    }

    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    private static void testFunction(List<RichPerson> persons) {
        System.out.println("Testing function...");
        Function<RichPerson, String> name = x -> x.getFirstName() + " " + x.getLastName();
        Function<String, String> sayHello = y -> "Hello, " + y;
        Function<RichPerson, String> composedFunction = sayHello.compose(name);
        List<String> transformedList = transform(persons, composedFunction);

        // Compose
        Function<String, String> exclaim = z -> z.concat("!!!");
        Function<String, String> toUpper = String::toUpperCase;

        transform(transformedList, compose(toUpper, exclaim)).forEach(System.out::println);
    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.andThen(f);
        }
        return result;
    }

    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function) {
        List<R> list = new ArrayList<>();
        for (T elem : elements) {
            list.add(function.apply(elem));
        }
        return list;
    }

    private static <T> void processList(List<T> elements, Consumer<T> consumer) {
        for (T e : elements ) {
            consumer.accept(e);
        }
    }

    private static void testConsumer(List<RichPerson> persons) {
        System.out.println("Testing consumer...");
        Consumer<RichPerson> raise = x -> x.setSalary(x.getSalary() * 11 /10);
        processList(persons, raise.andThen(System.out::println));
    }
}
