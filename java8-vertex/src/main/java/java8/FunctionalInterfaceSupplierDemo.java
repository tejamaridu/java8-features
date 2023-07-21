package java8;

import util.DataUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceSupplierDemo {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        /** --- Supplier Functional Interface ---
         Usage ::  **/

        // Example 1
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());


        // Example 2
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();
        System.out.println(time);
        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();
        System.out.println(time2);

        // Example 3
        Supplier<String[]> citySupplier = () -> {
            return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
        };
        Arrays.asList(citySupplier.get()).forEach(System.out::println);
    }
}


