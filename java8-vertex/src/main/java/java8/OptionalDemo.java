package java8;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        // **** Example 1 ****
        // Create a person with optional attributes
        Person person = new Person("John Doe", null, "123 Main St");

        // Using ifPresent to handle optional name
        Optional.ofNullable(person.getName())
                .ifPresent(name -> System.out.println("Name: " + name));

        // Using orElse to provide a default value for optional age
        int age = Optional.ofNullable(person.getAge()).orElse(0);
        System.out.println("Age: " + age);

        // Using map and orElse to transform and handle optional address
        String formattedAddress = Optional.ofNullable(person.getAddress())
                .map(addr -> "Address: " + addr)
                .orElse("Address not provided.");
        System.out.println(formattedAddress);

        // Using orElseThrow to throw an exception if name is null
        String name = Optional.ofNullable(person.getName())
                .orElseThrow(() -> new IllegalArgumentException("Name is required."));
        System.out.println("Name: " + name);

        // Using if-else loop to handle optional age
        if (person.getAge() != null) {
            System.out.println("Age: " + person.getAge());
        } else {
            System.out.println("Age not provided.");
        }

        // **** Example 2 ****
        String[] str = new String[10];
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if (checkNull.isPresent()) {
            String word = str[5].toLowerCase();
            System.out.print(str);
        } else {
            System.out.println("string is null");
        }
    }
}

class Person {
    private String name;
    private Integer age;
    private String address;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
