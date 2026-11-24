package pl.sergomrazzz.attendance;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class AttendanceProperties {

    private String name;
    private String academicYear;
    private Attendance attendance = new Attendance();

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

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public static class Attendance {

        private Integer minimumPercentage;
        private Integer maximumLateArrivals;

        public Integer getMinimumPercentage() {
            return minimumPercentage;
        }

        public void setMinimumPercentage(Integer minimumPercentage) {
            this.minimumPercentage = minimumPercentage;
        }

        public Integer getMaximumLateArrivals() {
            return maximumLateArrivals;
        }

        public void setMaximumLateArrivals(Integer maximumLateArrivals) {
            this.maximumLateArrivals = maximumLateArrivals;
        }
    }
}
