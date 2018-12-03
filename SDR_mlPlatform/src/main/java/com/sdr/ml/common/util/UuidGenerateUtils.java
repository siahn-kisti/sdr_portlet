package com.sdr.ml.common.util;

import java.util.UUID;

public class UuidGenerateUtils {

    static public String create(){

        UUID uuid = UUID.randomUUID();

        return uuid.toString();
    }
}
