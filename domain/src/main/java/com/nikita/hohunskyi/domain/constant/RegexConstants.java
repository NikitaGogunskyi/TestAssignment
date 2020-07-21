package com.nikita.hohunskyi.domain.constant;

public class RegexConstants {

    public static final String EMAIL = "[-A-Za-z_0-9]{1,41}@(.+)$";

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

}
