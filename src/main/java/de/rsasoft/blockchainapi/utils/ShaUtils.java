package de.rsasoft.blockchainapi.utils;

import lombok.experimental.UtilityClass;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
public class ShaUtils {

    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final  String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] encode(byte[] input){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA3-256");
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = messageDigest.digest(input);
        return result;
    }


    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }



}
