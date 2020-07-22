package com.nikita.hohunskyi.domain.constant;

public class RegexConstants {

    public static final String EMAIL = "[-A-Za-z_0-9]{1,41}@(.+)$";

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static final String PHONE_NUMBER = "^\\+380\\d{3}\\d{2}\\d{2}\\d{2}$";

    public static final String UUID_ID = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";
}
