import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        try {
            checkingRegistration(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkingRegistration(String login, String password, String confirmPassword) {

        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 символов");
        }
        if (!checkingSymbols(login)) {
            throw new WrongLoginException("Недопустимый символ в логине");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20 символов");
        }
        if (!checkingSymbols(password)) {
            throw new WrongLoginException("Недопустимый символ в пароле");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
    }

    private static boolean checkingSymbols(String word) {

        String regex = "\\w";

        for (int i = 0; i < word.length(); i++) {

            String checkedSymbol = word.substring(i, i + 1);

            boolean matches = Pattern.matches(regex, checkedSymbol);

            if (!matches) {
                return false;
            }
        }
        return true;
    }
}