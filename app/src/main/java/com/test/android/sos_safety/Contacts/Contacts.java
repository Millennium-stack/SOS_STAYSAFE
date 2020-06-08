package com.test.android.sos_safety.Contacts;

import java.io.Serializable;

public class Contacts implements Serializable
{
    private String name;
    private String phoneNumber;

    public Contacts() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
