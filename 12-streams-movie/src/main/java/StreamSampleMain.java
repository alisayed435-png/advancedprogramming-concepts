import java.util.*;
import java.util.stream.Collectors;

public class StreamSampleMain {

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", 30, true);
        Customer bob = new Customer("Bob", 25, false);
        Customer charlie = new Customer("Charlie", 35, true);
        Customer david = new Customer("David", 45, false);
        Customer eve = new Customer("Eve", 28, true);
        Customer fred = new Customer("Fred", 40, false);

        List<Customer> allCustomers = List.of(alice, bob, charlie, david, eve, fred);

        allCustomers.stream()
                .filter(c -> c.isPremium)
                .distinct()
                .skip(1)
                .forEach(System.out::println);

        List<Customer> aldiCustomers = List.of(alice, bob, charlie);
        List<Customer> lidlCustomers = List.of(david, eve);
        List<Customer> edekaCustomers = List.of(fred, alice);

        List<List<Customer>> allStoreCustomers = List.of(aldiCustomers, lidlCustomers, edekaCustomers);

        var result = allStoreCustomers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.summingInt(c -> c.age));

    }

    public record Customer(String name, int age, boolean isPremium) {

    }
}