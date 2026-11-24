package pl.sergomrazzz.student;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class StudentProperties {

    private String name;
    private String academicYear;
    private Students students = new Students();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public static class Students {

        private Integer minimumAge;
        private Integer maximumClassSize;

        public Integer getMinimumAge() {
            return minimumAge;
        }

        public void setMinimumAge(Integer minimumAge) {
            this.minimumAge = minimumAge;
        }

        public Integer getMaximumClassSize() {
            return maximumClassSize;
        }

        public void setMaximumClassSize(Integer maximumClassSize) {
            this.maximumClassSize = maximumClassSize;
        }
    }
}
