package com.nikita.hohunskyi.persistence.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public final class IdGeneratorUtils {

    private IdGeneratorUtils() {

    }

    /**
     * Generate id for UPSA id format.
     *
     * @return random generated id
     */
    public static String generateUserId() {
        return RandomStringUtils.randomNumeric(20);
    }

    /**
     * Generate id in UUID format.
     *
     * @return random generated id
     * @see UUID#randomUUID()
     */
    public static String generateUUID() {
        return UUID
                .randomUUID()
                .toString();
    }

}

