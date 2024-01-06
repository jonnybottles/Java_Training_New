package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MainChallenge {

    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgij = new Course("CGIJ", "Creating Games in Java");

        List<Student> students = IntStream
                .rangeClosed(1,5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s-> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);

        double avgPercent = totalPercent / students.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n", avgPercent);

        int topPercent = (int) (1.25 * avgPercent);
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        Comparator<Student> longTermStudent =
                Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") ==0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();
        hardWorkers.forEach(s-> {
            s.addCourse(cgij);
            System.out.println(s);
        });

    }
}
