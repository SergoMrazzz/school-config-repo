package pl.sergomrazzz.schedule;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class ScheduleProperties {

    private String name;
    private String academicYear;
    private Schedule schedule = new Schedule();

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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public static class Schedule {

        private Integer lessonDurationMinutes;
        private Integer breakDurationMinutes;

        public Integer getLessonDurationMinutes() {
            return lessonDurationMinutes;
        }

        public void setLessonDurationMinutes(Integer lessonDurationMinutes) {
            this.lessonDurationMinutes = lessonDurationMinutes;
        }

        public Integer getBreakDurationMinutes() {
            return breakDurationMinutes;
        }

        public void setBreakDurationMinutes(Integer breakDurationMinutes) {
            this.breakDurationMinutes = breakDurationMinutes;
        }
    }
}
