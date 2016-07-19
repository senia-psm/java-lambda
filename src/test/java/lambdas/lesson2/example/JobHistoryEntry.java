package lambdas.lesson2.example;

import lambdas.lesson1.Person;

public class JobHistoryEntry {
    private final int duration;
    private final String position;
    private final String employer;

    public JobHistoryEntry(int duration, String position, String employer) {
        this.duration = duration;
        this.position = position;
        this.employer = employer;
    }

    public int getDuration() {
        return duration;
    }

    public String getPosition() {
        return position;
    }

    public String getEmployer() {
        return employer;
    }

    public JobHistoryEntry withDuration(int duration) {
        return new JobHistoryEntry(duration, position, employer);
    }

    public JobHistoryEntry withPosition(String position) {
        return new JobHistoryEntry(duration, position, employer);
    }

    public JobHistoryEntry withEmployer(String employer) {
        return new JobHistoryEntry(duration, position, employer);
    }

    @Override
    public String toString() {
        return "JobHistoryEntry{" +
                "duration=" + duration +
                ", position='" + position + '\'' +
                ", employer='" + employer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobHistoryEntry that = (JobHistoryEntry) o;

        if (duration != that.duration) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        return employer != null ? employer.equals(that.employer) : that.employer == null;

    }

    @Override
    public int hashCode() {
        int result = duration;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (employer != null ? employer.hashCode() : 0);
        return result;
    }
}
