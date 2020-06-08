package com.test.android.sos_safety.Parameters;

import java.io.Serializable;

public class Parameters implements Serializable {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "contacts_db";
    public static final String TABLE_NAME = "contacts_table";


    //Keys of our table in db
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone_number";
}
