package backend.challenge.service.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateUtils {

    public static boolean isValidEmailAddress(String email) {
       return EmailValidator.getInstance().isValid(email);
    }

    public static boolean isPasswordValid (String passwordPatern, String password){

        Pattern pattern = Pattern.compile(passwordPatern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
