import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String code = "ASB-2387";
        System.out.println(validateReferenceCode(code));

        String cpf = "123.654.789-00";
        System.out.println(validateCPF(cpf));

        String text = "I like to develop algorithms. #Java #VSCode #PHP";
        System.out.println(findHashtags(text));

        String password = "aaaaa65A%";
        System.out.println(isValidPassword(password));
    }

    public static boolean validateReferenceCode(String referenceCode) {
        Pattern pattern = Pattern.compile("^[A-Z]{3}-[0-9]{4}$");
        Matcher matcher = pattern.matcher(referenceCode);
        return matcher.matches();
    }

    public static boolean validateCPF(String cpf) {
        Pattern pattern = Pattern.compile("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$");
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    public static List<String> findHashtags(String text) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(text);
        List<String> hashtags = new ArrayList<>();

        while(matcher.find()){
            hashtags.add(matcher.group());
        }
        return hashtags;
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{9}$";
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
