package lambdas.lesson2.example;

import lambdas.lesson1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class Filtering {
    public static class FilterUtil<T> {
        private final List<T> list;

        public FilterUtil(List<T> list) {
            this.list = list;
        }

        public List<T> getList() {
            return list;
        }

        private FilterUtil<T> filter(Predicate<T> condition) {
            final List<T> result = new ArrayList<T>();
            for (T t : list) {
                if (condition.test(t)) {
                    result.add(t);
                }
            }
            return new FilterUtil<T>(result);
        }
    }

    private static boolean hasDevExperience(Employee e) {
        return new FilterUtil<>(e.getJobHistory())
                .filter(j -> j.getPosition().equals("dev"))
                .getList()
                .size() > 0;
    }

    private static boolean workedInEpamMoreThenOneYear(Employee e) {
        return new FilterUtil<>(e.getJobHistory())
                .filter(j -> j.getEmployer().equals("epam"))
                .filter(j -> j.getDuration() > 1)
                .getList()
                .size() > 0;
    }

    @Test
    public void filtering() {
        final List<Employee> employees =
                Arrays.asList(
                        new Employee(
                                new Person("John", "Galt"),
                                Arrays.asList(
                                        new JobHistoryEntry(2, "dev", "epam"),
                                        new JobHistoryEntry(1, "dev", "google")
                                )),
                        new Employee(
                                new Person("John", "Doe"),
                                Arrays.asList(
                                        new JobHistoryEntry(3, "QA", "yandex"),
                                        new JobHistoryEntry(1, "QA", "epam"),
                                        new JobHistoryEntry(1, "dev", "abc")
                                )),
                        new Employee(
                                new Person("John", "White"),
                                Arrays.asList(
                                        new JobHistoryEntry(5, "QA", "epam")
                                ))
                );

        final List<Employee> filteredList = new FilterUtil<>(employees)
                .filter(e -> e.getPerson().getFirstName().equals("John"))
                .filter(Filtering::hasDevExperience)
                .filter(Filtering::workedInEpamMoreThenOneYear)
                .getList();

        assertEquals(filteredList.size(), 1);
        assertEquals(filteredList.get(0).getPerson(), new Person("John", "Galt"));
    }

    public static class LazyFilterUtil<T> {
        public LazyFilterUtil(List<T> list) {
            // TODO
        }

        public List<T> force() {
            // TODO
            throw new UnsupportedOperationException();
        }

        private LazyFilterUtil<T> filter(Predicate<T> condition) {
            // TODO
            throw new UnsupportedOperationException();
        }
    }

    private static boolean workedInEpamMoreThenOneYearLazy(Employee e) {
        return new LazyFilterUtil<>(e.getJobHistory())
                .filter(j -> j.getEmployer().equals("epam"))
                .filter(j -> j.getDuration() > 1)
                .force()
                .size() > 0;
    }


    @Test
    public void lazy_filtering() {
        final List<Employee> employees =
                Arrays.asList(
                        new Employee(
                                new Person("John", "Galt"),
                                Arrays.asList(
                                        new JobHistoryEntry(2, "dev", "epam"),
                                        new JobHistoryEntry(1, "dev", "google")
                                )),
                        new Employee(
                                new Person("John", "Doe"),
                                Arrays.asList(
                                        new JobHistoryEntry(3, "QA", "yandex"),
                                        new JobHistoryEntry(1, "QA", "epam"),
                                        new JobHistoryEntry(1, "dev", "abc")
                                )),
                        new Employee(
                                new Person("John", "White"),
                                Collections.singletonList(
                                        new JobHistoryEntry(5, "QA", "epam")
                                ))
                );

        final List<Employee> filteredList = new LazyFilterUtil<>(employees)
                .filter(e -> e.getPerson().getFirstName().equals("John"))
                .filter(Filtering::hasDevExperience)
                .filter(Filtering::workedInEpamMoreThenOneYearLazy)
                .force();

        assertEquals(filteredList.size(), 1);
        assertEquals(filteredList.get(0).getPerson(), new Person("John", "Galt"));
    }

}
