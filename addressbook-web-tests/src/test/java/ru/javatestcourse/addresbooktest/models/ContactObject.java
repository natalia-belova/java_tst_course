package ru.javatestcourse.addresbooktest.models;

public class ContactObject {
    private final String last_name;
    private final String address;
    private final String home_phone;
    private final String email;
    private final String first_name;
    private String group_name;

    public ContactObject(String last_name, String address, String home_phone, String email, String first_name, String group_name) {
        this.last_name = last_name;
        this.address = address;
        this.home_phone = home_phone;
        this.email = email;
        this.first_name = first_name;
        this.group_name = group_name;
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

    public String getGroup_name() {
        return group_name;
    }
}
