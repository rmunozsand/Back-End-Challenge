package backend.challenge.service.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidateUtilsTest {

    @Test
    void isValidEmailAddress() {

        String email = "juan@rodriguez.com";
        boolean isValidEmailAddress = ValidateUtils.isValidEmailAddress(email);
        Assertions.assertEquals(true, isValidEmailAddress);

        String email2 = "j@rodriguez.org";
        boolean isValidEmailAddress2 = ValidateUtils.isValidEmailAddress(email2);
        Assertions.assertEquals(true, isValidEmailAddress2);

        String email3 = "juanrodriguez.com";
        boolean isValidEmailAddress3 = ValidateUtils.isValidEmailAddress(email3);
        Assertions.assertEquals(false, isValidEmailAddress3);

        String email4 = "juan@rodriguezcom";
        boolean isValidEmailAddress4 = ValidateUtils.isValidEmailAddress(email4);
        Assertions.assertEquals(false, isValidEmailAddress4);
    }

    @Test
    void isPasswordValid() {

        String passWordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()?[{}]:;',?/*~$^+=<>]).{8,20}$";

        String password = "AAAbbbccc@123";
        boolean isPasswordValid = ValidateUtils.isPasswordValid(passWordPattern, password);
        Assertions.assertEquals(true, isPasswordValid);

        String password2 = "A!@#&()–a1";
        boolean isPasswordValid2 = ValidateUtils.isPasswordValid(passWordPattern, password2);
        Assertions.assertEquals(true, isPasswordValid2);

        String password3 = "12345678";
        boolean isPasswordValid3 = ValidateUtils.isPasswordValid(passWordPattern, password3);
        Assertions.assertEquals(false, isPasswordValid3);

        String password4 = "ABC123$$$";
        boolean isPasswordValid4 = ValidateUtils.isPasswordValid(passWordPattern, password4);
        Assertions.assertEquals(false, isPasswordValid4);
    }
}