package java8;

import util.DataUtil;

import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterfaceConsumerDemo {

    public static void main(String[] args) {

        /** --- Consumer Functional Interface ---
         Usage :: consumes a value and performs some action on it without returning anything. **/
        List<Integer> nums = DataUtil.nums;
        System.out.println("Numbers before Processing Using Consumer & List.set method " + nums);

        // Using a Consumer to square each element of the list
        Consumer<Integer> squareConsumer = (num) -> {
            nums.set(nums.indexOf(num), num * num);
        };
        nums.forEach(squareConsumer);

        // Printing the modified list
        System.out.println("Numbers after Processing " + nums);


        /** Other way for above solution, I think this is a better way,
         because we can pass this to any arraylist of Integer **/
        Consumer<Integer> squareCons = (n) -> {
            n = n * n;
        };

        List<Integer> nums2 = DataUtil.nums;
        List<Integer> nums3 = DataUtil.nums;
        System.out.println("Numbers before Processing nums2 " + nums2);
        System.out.println("Numbers before Processing nums3 " + nums3);

        nums2.forEach(squareCons);
        nums3.forEach(squareCons);
        System.out.println("Numbers after Processing nums2 " + nums2);
        System.out.println("Numbers after Processing nums3 " + nums3);


        // Example: Chaining two Consumers using andThen()
        Consumer<String> printUpperCase = (str) -> System.out.println(str.toUpperCase());
        Consumer<String> printLowerCase = (str) -> System.out.println(str.toLowerCase());

        Consumer<String> combinedConsumer = printUpperCase.andThen(printLowerCase);

        combinedConsumer.accept("Hello, World!");
    }
}
