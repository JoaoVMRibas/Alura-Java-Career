import java.util.*;

public class CollectionsAndStream {
    public static void main(String[] args) {
        List<String> eventsList = new ArrayList<>();
        eventsList.add("IA Conference Brasil");
        eventsList.add("DevFest");
        eventsList.add("Cloud Expo");
        eventsList.add("DevFest");
        Set<String> distinctList = new HashSet<>(eventsList);
//        System.out.println("Antes: " + eventsList);
//        System.out.println("Depois: " + distinctList);

        List<String> employeesList = List.of("Ana", "Bruno", "Carlos", "Amanda", "Alice", "Daniel", "Caroline");
        List<String> shortNames = employeesList.stream()
                .filter(employee -> employee.length()<=5)
                .toList();
//        System.out.println("Antes: " + employeesList);
//        System.out.println("Depois: " + shortNames);

        List<Integer> numbers = List.of(2, 3, 5, 7, 11);
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number*number)
                .toList();
//        System.out.println("Antes: " + numbers);
//        System.out.println("Depois: " + squaredNumbers);

        List<Double> productPricesList = List.of(29.99, 49.50, 15.75, 99.99);
        double totalPrice = productPricesList.stream()
                .reduce(0.0,Double::sum);
        double tax = totalPrice * 0.08;
//        System.out.printf("%.2f%n",totalPrice);
//        System.out.printf("%.2f%n",totalPrice + tax);

        List<Double> gradesList = List.of(7.5, 8.0, 6.5, 9.0, 10.0);
        double gradesSum = gradesList.stream()
                .reduce(0.0,Double::sum);
        double gradeAvg = gradesSum / gradesList.size();
        double maxGrade = gradesList.stream()
                .max(Double::compare).get();
        double minGrade = gradesList.stream()
                .min(Double::compare).get();
//        System.out.println("Sum: "+gradesSum);
//        System.out.println("Avg: "+gradeAvg);
//        System.out.println("Max: "+maxGrade);
//        System.out.println("Min: "+minGrade);
    }
}
