package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;
    private Date BirthDate;

    public Client() {
    }

    public Client(String name, String email, Date birthDate) throws ParseException {
        this.name = name;
        this.email = email;
        this.BirthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String toString() {
        return name + " (" + sdf.format(BirthDate) + ") - " + email;
    }
}
