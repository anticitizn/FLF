package Person;

import java.util.Calendar;

public abstract class Person {

    protected int id;
    protected final String firstName;
    protected  final String lastName;
    protected final Calendar dateOfBirth;

    public Person(int id, final String firstName, final String lastName, final String dateOfBirthString ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        dateOfBirth = Utility.convertStringToCalendarDate(dateOfBirthString);

    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }


    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (!(object instanceof Person)) {
            return false;
        }

        if (this.getClass() != object.getClass()) {
            return false;
        }

        final Person employee = (Person) object;
        return id == employee.getID();
    }
}
