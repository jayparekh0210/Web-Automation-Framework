package com.automation.helper;


import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@Slf4j
public class EncodeDecode {

    public String getEncodedString(String str) {
        byte[] encoded = Base64.getEncoder().encode(str.getBytes());
        return new String(encoded);
    }

    public String getDecodedString(String str) {
        byte[] decoded = Base64.getDecoder().decode(str);
        return new String(decoded);
    }

}
