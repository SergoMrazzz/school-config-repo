package pl.sergomrazzz.grade;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class GradeProperties {

    private String name;
    private String academicYear;
    private Grades grades = new Grades();

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

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public static class Grades {

        private Integer minimumPassingGrade;
        private BigDecimal examWeight;

        public Integer getMinimumPassingGrade() {
            return minimumPassingGrade;
        }

        public void setMinimumPassingGrade(Integer minimumPassingGrade) {
            this.minimumPassingGrade = minimumPassingGrade;
        }

        public BigDecimal getExamWeight() {
            return examWeight;
        }

        public void setExamWeight(BigDecimal examWeight) {
            this.examWeight = examWeight;
        }
    }
}
