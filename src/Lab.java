/***
 JAVADOC
 @author Pablo Yague
 @version 12/10/2023
 Created for CS180 Project 2
 **/
public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;
    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }
    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
        this.morning = new Session();
        this.afternoon = new Session();
    }
    public Session getMorning() {
        return morning;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String listAvailabilities() {
        String out = "";
        boolean foundAvail = false;
        if (morning.getEnrollment() == 0) {
            out = out + "Morning Available\n";
            foundAvail = true;
        }
        if (afternoon.getEnrollment() == 0) {
            out = out + "Afternoon Available\n";
            foundAvail = true;
        }
        if (!foundAvail) {
            out = "No Availabilities";
        }
        return out;
    }
    public String listReservations() {
        String out = "";
        boolean foundRes = false;
        if (morning.getEnrollment() > 0) {
            out = out + "Morning Reserved\n";
            foundRes = true;
        }
        if (afternoon.getEnrollment() > 0) {
            out = out + "Afternoon Reserved\n";
            foundRes = true;
        }
        if (!foundRes) {
            out = "No Reservations";
        }
        return out;
    }
    @Override
    public String toString() {
        String mornStr = "";
        String aftStr = "";
        if (morning.getEnrollment() == 0) {
            mornStr = "Available";
        } else {
            mornStr = morning.toString();
        }
        if (afternoon.getEnrollment() == 0) {
            aftStr = "Available";
        } else {
            aftStr = afternoon.toString();
        }
        String out = "Lab{Capacity - " + Integer.toString(capacity) + ", Location - "
                + location + ", Morning: " + mornStr + ", Afternoon: " + aftStr + "}";
        return out;
    }
}