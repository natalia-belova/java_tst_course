package ru.javatestcourse.addresbooktest.models;

public class ContactObject {
    private final String last_name;
    private final String address;
    private final String home_phone;
    private final String email;
    private final String first_name;

    public ContactObject(String last_name, String address, String home_phone, String email, String first_name) {
        this.last_name = last_name;
        this.address = address;
        this.home_phone = home_phone;
        this.email = email;
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }
}
