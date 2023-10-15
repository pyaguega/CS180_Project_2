/***
 JAVADOC
 @author Pablo Yague
 @version 12/10/2023
 Created for CS180 Project 2
 **/
public class Session {
    private String name;
    private int enrollment;
    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }
    public Session() {
        this.name = "";
        this.enrollment = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        String out = "Session{Name - " + this.name + ", Enrollment - " + Integer.toString(this.enrollment) + "}";
        return out;
    }
}