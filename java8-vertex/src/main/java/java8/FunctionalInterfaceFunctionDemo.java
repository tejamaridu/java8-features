package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceFunctionDemo {

    private static Employee e1;

    public static void main(String[] args) {

        /** --- Function Functional Interface ---
         Usage ::  **/

        // Example 1
        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Function<String, Character> getFirstCharFunction = city -> {
            return city.charAt(0);
        };
        cities.stream().map(getFirstCharFunction)
                .forEach(System.out::println);


        // Example 2
        Function<String, Integer> func = x -> x.length();
        Integer apply = func.apply("mkyong");   // 6
        System.out.println(apply);


        // Example 3

        Employee e1= new Employee();
        e1.setFirstName("Pooja");
        e1.setLastName("Kds");
        Employee e2= new Employee();
        e2.setFirstName("Raja");
        e2.setLastName("Vsa");
        Employee e3= new Employee();
        e3.setFirstName("Hari");
        e3.setLastName("Pod");

        List<Employee> lst = new ArrayList<>();
        lst.add(e1);
        lst.add(e2);
        lst.add(e3);

                List<String> firstNames = lst.stream().filter(e -> e.getFirstName() != null)
                .map(Employee::getFirstName).collect(Collectors.toList());
        System.out.println(firstNames);


    }
}

class Employee {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


