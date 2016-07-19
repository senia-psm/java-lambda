package lambdas.lesson2.example;

import com.google.common.collect.ImmutableList;
import lambdas.lesson1.Person;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final Person person;
    private final List<JobHistoryEntry> jobHistory;

    public Employee(Person person, List<JobHistoryEntry> jobHistory) {
        this.person = person;
        this.jobHistory = jobHistory;
    }

    public Person getPerson() {
        return person;
    }

    public List<JobHistoryEntry> getJobHistory() {
        return new ArrayList<>(jobHistory);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "person=" + person +
                ", jobHistory=" + jobHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (person != null ? !person.equals(employee.person) : employee.person != null) return false;
        return jobHistory != null ? jobHistory.equals(employee.jobHistory) : employee.jobHistory == null;

    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (jobHistory != null ? jobHistory.hashCode() : 0);
        return result;
    }
}
