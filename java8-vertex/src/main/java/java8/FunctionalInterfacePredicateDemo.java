package java8;

import util.DataUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfacePredicateDemo {

    public static void main(String[] args) {

        /** --- Predicate Functional Interface ---
         Usage ::  **/

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1
        List<String> names = DataUtil.names;
        Predicate<String> startsWithSFunction = str -> str.startsWith("S");
        // names.stream().filter(startsWithSFunction).forEach(System.out::println);
        List<String> namesWithS = names.stream().filter(startsWithSFunction).collect(Collectors.toList());
        System.out.println(" Example 1 -- " +namesWithS);


        // Example 2
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(" Example 2 -- " +collect);


        // Example 3
        Predicate<Integer> noGreaterThan5 =  x -> x > 5;
        collect = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());
        System.out.println(" Example 3 -- " +collect); // [6, 7, 8, 9, 10]


        // Example 4 -- without Predicate.and()
        // list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // multiple filters
        collect = list.stream()
                .filter(x -> x > 5 && x < 8).collect(Collectors.toList());
        System.out.println(" Example 4 -- without Predicate.and() " +collect);


        // Example 5 -- with Predicate.and()
        noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;
        // list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        collect = list.stream()
                .filter(noGreaterThan5.and(noLessThan8))
                .collect(Collectors.toList());
        System.out.println(" Example 5 -- with Predicate.and() " +collect);


        // Example 6 -- with Predicate.or()
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");
        List<String> listStr = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        List<String> collectStr = listStr.stream()
                .filter(lengthIs3.or(startWithA))
                .collect(Collectors.toList());
        System.out.println(" Example 6 -- with Predicate.or() " +collectStr);


        // Example 7 -- with Predicate.negate()
        startWithA = x -> x.startsWith("A");
        // listStr = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        collectStr = listStr.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());
        System.out.println(" Example 7 -- with Predicate.negate() " +collectStr);


        // Example 8 -- with Predicate.test()
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(" Example 8 -- with Predicate.test() " + lesserthan.test(10));


        // Example 9 -- with Predicate.test()
        listStr = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        System.out.println(" Example 9 -- with Predicate.test() " + StringProcessor.filter(
                listStr, x -> x.startsWith("A")));  // [A, AA, AAA]

        System.out.println(" Example 9 -- with Predicate.test() " + StringProcessor.filter(
                listStr, x -> x.startsWith("A") && x.length() == 3)); // [AAA]

        // Example 10 -- with Predicate.test()
        Predicate<String> startWithB = x -> x.startsWith("B");
        System.out.println("Example 10 -- with Predicate.test() "
                + listStr.stream().filter(startWithB::test)
                .collect(Collectors.toList()));
    }
}

class StringProcessor {
    static List<String> filter(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
