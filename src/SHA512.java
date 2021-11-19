
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static jdk.nashorn.tools.ShellFunctions.input;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a
 */
public class SHA512 {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String input=null;
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.reset();
        digest.update(input.getBytes("utf8"));
        String hashedString = String.format("%0128x", new BigInteger(1, digest.digest()));
    }

}
