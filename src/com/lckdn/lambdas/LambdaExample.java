package com.lckdn.lambdas;

import com.lckdn.lambdas.com.lckdn.lambda.model.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
    double process(T element);
}

@FunctionalInterface
interface Operation {
    public static void measure(Operation function) {
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();
        System.out.println("Time spent " + (end - start));
    }

    void process();

    default Operation combineOperation(Operation that) {
        return () -> {
            process();
            that.process();
        };
    }
}

@FunctionalInterface
interface LoggingProcessor {
    void process();
}

public class LambdaExample {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            intList.add(i);
        }

//        List<Double> doubleList = new ArrayListTest<>();
//        doubleList.add(6.4);
//        doubleList.add(8.6);
//        doubleList.add(1.23);
//        doubleList.add(4.13);
//        doubleList.add(12.2);

//        processElements(intList, x -> Math.sin(x.doubleValue()));
//        processElements(doubleList, x -> Math.sin(x.doubleValue()));

//        TimeUtil.measure(() -> Arrays.sort(createRandomArray()));

//        String Message = "Hello";
//        Double d = 0.123;

//        TransformUtils<Double> doubleUtils = new TransformUtils<>();
//        System.out.println(doubleUtils.transform(d, Math::sin));
//
//        TransformUtils<String> stringUtils = new TransformUtils<>();
//        System.out.println(stringUtils.transform(Message, TransformUtils::exclaim));
//
//        String suffix = "Alex";
//
//        System.out.println(stringUtils.transform(suffix, Message::concat));
//
//        System.out.println(stringUtils.transform(Message, String::toUpperCase));
//
//        System.out.println(stringUtils.transform(Message, String::new));

//        LambdaScopeTest scope = new LambdaScopeTest();
//        LambdaScopeTest.LambdaScopeInner inner = scope.new LambdaScopeInner();
//        inner.testScope(9999.0000);

//        Operation.measure(() -> Arrays.sort(createRandomArray()));

        Circle circle = new Circle();
        System.out.println(circle.calcSomething());
    }

    private static <T extends Number> void processElements(List<T> intList, ElementProcessor function) {
        List<Double> doubleList = new ArrayList<>();

        for (Number i : intList) {
            doubleList.add(function.process(i));
        }
        System.out.println(doubleList);
    }

    private static double multiply(int x, int y) {
        //  System.out.println("x = " + x + "\n" + "y = " +y);
        return x * y / 10.0;
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = r.nextInt(myArray.length);
        }
        return myArray;
    }

    public static class LoggerUtil {

        private static void additionalLog(LoggingProcessor processor) {
            System.out.println();
        }
    }
}
