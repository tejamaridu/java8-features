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
        List<String> names = DataUtil.names;
        Predicate<String> startsWithSFunction = str -> str.startsWith("S");
        names.stream().filter(startsWithSFunction).forEach(System.out::println);

        List<String> namesWithS = names.stream().filter(startsWithSFunction).collect(Collectors.toList());
        System.out.println(namesWithS);
    }
}
