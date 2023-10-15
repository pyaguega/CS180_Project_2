/***
 JAVADOC
 @author Pablo Yague
 @version 12/10/2023
 Created for CS180 Project 2
 **/
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;
    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }
    public Lab getLabOne() {
        return labOne;
    }

    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }

    public Lab getLabTwo() {
        return labTwo;
    }

    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }

    public Lab getLabThree() {
        return labThree;
    }

    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }
    public int calculateTotalCapacity() {
        return labOne.getCapacity() * 2 + labTwo.getCapacity() * 2 + labThree.getCapacity() * 2;
    }
    public double calculateTotalUtilization() {
        double sumOccupation = labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment() +
                labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment() +
                labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();
        return (sumOccupation) / (calculateTotalCapacity());
    }
    public int calculateAvailableSeats() {
        int availableSeats = calculateTotalCapacity() - (labOne.getMorning().getEnrollment()
                + labOne.getAfternoon().getEnrollment() +
                labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment()
                + labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment());
        return  (availableSeats);
    }
    public String listReservedLabs() {
        String out = "";
        out = out + "Lab One\n";
        int morningOne = labOne.listReservations().indexOf("Morning");
        int afternoonOne = labOne.listReservations().indexOf("Afternoon");
        if (morningOne != -1) {
            out = out + "Morning: Reserved\n";
        }
        if (afternoonOne != -1) {
            out = out + "Afternoon: Reserved\n";
        }
        if (morningOne == -1 && afternoonOne == -1 ) {
            out = out + "No Reservations\n";
        }
        out = out + "Lab Two\n";
        int morningTwo = labTwo.listReservations().indexOf("Morning");
        int afternoonTwo = labTwo.listReservations().indexOf("Afternoon");
        if (morningTwo != -1) {
            out = out + "Morning: Reserved\n";
        }
        if (afternoonTwo != -1) {
            out = out + "Afternoon: Reserved\n";
        }
        if (morningTwo == -1 && afternoonTwo == -1 ) {
            out = out + "No Reservations\n";
        }
        out = out + "Lab Three\n";
        int morningThree = labThree.listReservations().indexOf("Morning");
        int afternoonThree = labThree.listReservations().indexOf("Afternoon");
        if (morningThree != -1) {
            out = out + "Morning: Reserved\n";
        }
        if (afternoonThree != -1) {
            out = out + "Afternoon: Reserved\n";
        }
        if (morningThree == -1 && afternoonThree == -1 ) {
            out = out + "No Reservations\n";
        }
        return out;
    }
    public String listAvailableLabs() {
        String out = "";
        out = out + "Lab One\n";
        int morningOne = labOne.listAvailabilities().indexOf("Morning");
        int afternoonOne = labOne.listAvailabilities().indexOf("Afternoon");
        if (morningOne != -1) {
            out = out + "Morning: Available\n";
        }
        if (afternoonOne != -1) {
            out = out + "Afternoon: Available\n";
        }
        if (morningOne == -1 && afternoonOne == -1 ) {
            out = out + "No Availabilities\n";
        }
        out = out + "Lab Two\n";
        int morningTwo = labTwo.listAvailabilities().indexOf("Morning");
        int afternoonTwo = labTwo.listAvailabilities().indexOf("Afternoon");
        if (morningTwo != -1) {
            out = out + "Morning: Available\n";
        }
        if (afternoonTwo != -1) {
            out = out + "Afternoon: Available\n";
        }
        if (morningTwo == -1 && afternoonTwo == -1 ) {
            out = out + "No Availabilities\n";
        }
        out = out + "Lab Three\n";
        int morningThree = labThree.listAvailabilities().indexOf("Morning");
        int afternoonThree = labThree.listAvailabilities().indexOf("Afternoon");
        if (morningThree != -1) {
            out = out + "Morning: Available\n";
        }
        if (afternoonThree != -1) {
            out = out + "Afternoon: Available\n";
        }
        if (morningThree == -1 && afternoonThree == -1 ) {
            out = out + "No Availabilities\n";
        }
        return out;
    }
    public String addReservation(String location, String time, String name, int enrollment) {
        Lab lab;
        Session session;
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            lab = labOne;
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            lab = labTwo;
        } else if (location.equalsIgnoreCase(labThree.getLocation())) {
            lab = labThree;
        } else {
            return "Error. Invalid location";
        }
        if (enrollment > lab.getCapacity()) {
            return "Error. Capacity exceeded";
        } else if (time.equalsIgnoreCase("Morning") && enrollment <= lab.getCapacity()) {
            session = lab.getMorning();
        } else if (time.equalsIgnoreCase("Afternoon") && enrollment <= lab.getCapacity()) {
            session = lab.getAfternoon();
        } else {
            return "Error. Invalid time.";
        }
        session.setName(name);
        session.setEnrollment(enrollment);
        return "Reservation added!";
    }
    public String removeReservation(String location, String time) {
        Lab lab;
        Session session;
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            lab = labOne;
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            lab = labTwo;
        } else if (location.equalsIgnoreCase(labThree.getLocation())) {
            lab = labThree;
        } else {
            return "Error. Invalid location";
        }
        if (time.equalsIgnoreCase("Morning") && lab.getMorning().getEnrollment() != 0) {
            session = lab.getMorning();
        } else if (time.equalsIgnoreCase("Afternoon") && lab.getAfternoon().getEnrollment() != 0) {
            session = lab.getAfternoon();
        } else {
            return "Error. Invalid time.";
        }
        session.setName("");
        session.setEnrollment(0);
        return "Reservation removed!";
    }
    public String modifyReservation(String location, String time, String name, int enrollment) {
        Lab lab;
        Session session;
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            lab = labOne;
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            lab = labTwo;
        } else if (location.equalsIgnoreCase(labThree.getLocation())) {
            lab = labThree;
        } else {
            return "Error. Invalid location";
        }
        if (enrollment > lab.getCapacity()) {
            return "Error. Capacity exceeded";
        } else if (time.equalsIgnoreCase("Morning") && lab.getMorning().getEnrollment() != 0) {
            session = lab.getMorning();
        } else if (time.equalsIgnoreCase("Afternoon") && lab.getAfternoon().getEnrollment() != 0) {
            session = lab.getAfternoon();
        } else {
            return "Error. Invalid time.";
        }
        session.setName(name);
        session.setEnrollment(enrollment);
        return "Reservation modified!";
    }
    @Override
    public String toString() {
        return "LabManager{" + labOne.toString() + ", " + labTwo.toString() + ", " + labThree.toString() + "}";
    }
}