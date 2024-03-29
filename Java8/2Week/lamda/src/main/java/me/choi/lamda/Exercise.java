package me.choi.lamda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise {
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);

        Runnable runnable = () -> System.out.println("runnalble");
        runnable.run();

        List<Apple> appleList = Arrays.asList(new Apple(60, "green"), new Apple(100, "red"));

        process(() ->{
            System.out.println("choi");
        });

        /*동작파라미터화 Apple*/
        Apple apple = new Apple(50,"Red");
        /*(1) 메서드 사용하지 않고 익명클래스를 바로 람다화*/
        ApplePredicate applePredicate = (apple2) -> apple2.getWeitght() > 50;
        System.out.println(applePredicate.test(apple));
        /*메서드 사용*/
        Boolean result = appleProcess(((Apple apple2) -> apple2.getWeitght() >30), apple);
        System.out.println("result:: "+result);

//        String processFile = processFile((BufferedReader br) -> br.readLine() + br.readLine());
//        System.out.println(processFile);

        List<String> arrayStrings = Arrays.asList("choi", "", "jun", "", "woo");

        System.out.println("Predicate의 사용");
        /*Predicate의 사용*/
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(arrayStrings, nonEmptyStringPredicate);
        //List<String> nonEmpty = filter(arrayStrings, ((String s)->!s.isEmpty()));

        for(String s : nonEmpty) {
            System.out.println(s);
        }
        /*Consumer의 사용*/
        List<Integer> arrayIntegers = Arrays.asList(1, 2, 3, 4, 5);
        forEach(arrayIntegers, (Integer i) -> System.out.println(i));

        /*Function의 사용*/
        List<String> stringList = Arrays.asList("choi", "jun", "woo");
        List<Integer> map = map(stringList, (String s) -> s.length());



        System.out.println(map);
    }

    public  static <T,R> List<R> map(List<T> list, Function<T,R> f) {

        List<R> result = new ArrayList<>();
        for(T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T t : list)
            c.accept(t);
    }

    public static <V> List<V> filter(List<V> list, Predicate<V> p) {
        List<V> result = new ArrayList<>();
        for(V s : list) {
            if(p.test(s)) {
                result.add(s);
            }
         }
        return result;
    }

    public static void process(Runnable runnable) {
        runnable.run()                                                                                                                                                                                                    ;
    }

    public static boolean appleProcess(ApplePredicate applePredicate, Apple apple) {
        System.out.println(apple.getWeitght());
        return applePredicate.test(apple);
    }

    public static String processFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return p.processFile(br);
    }







}
