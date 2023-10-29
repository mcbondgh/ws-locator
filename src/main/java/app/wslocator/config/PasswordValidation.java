package app.wslocator.config;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidation {
    public static String hashPlainText(String plainText) {
        String saltValue = BCrypt.gensalt();
        return BCrypt.hashpw(plainText, saltValue);
    }

    public static boolean verifyHashValue(String plainText, String hashValue) {
        return BCrypt.checkpw(plainText, hashValue);
    }
}
