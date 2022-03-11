package Person;

import ID.IDCard;
import Joystick.AbstractJoystick;

import java.util.Calendar;

public abstract class Person {
    protected int id;
    protected final String firstName;
    protected  final String lastName;
    protected final Calendar dateOfBirth;
    protected IDCard idCard;
    private final AbstractJoystick joystick;

    public Person(int id, final String firstName, final String lastName, final String dateOfBirthString, AbstractJoystick joystick) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        dateOfBirth = Utility.convertStringToCalendarDate(dateOfBirthString);
        this.joystick = joystick;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public IDCard getIdCard() {
        return idCard;
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

    public AbstractJoystick getJoystick() {
        return joystick;
    }

    public String createEncryptedString(){
        StringBuilder encryptedString = new StringBuilder();
        encryptedString.append("FT-DUS-FLF-").
                append(getID()).append("-").
                append(getFirstName()).append(" ").
                append(getLastName()).append("-6072");
        return encryptedString.toString();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (!(object instanceof final Person employee)) {
            return false;
        }

        if (this.getClass() != object.getClass()) {
            return false;
        }

        return id == employee.getID();
    }
}
