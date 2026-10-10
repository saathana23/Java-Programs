
public class PasswordSecurity {
    private final String password;

    public PasswordSecurity(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordSecurity p1 = new PasswordSecurity("abc");
        PasswordSecurity p2 = new PasswordSecurity("abcdefg");
        PasswordSecurity p3 = new PasswordSecurity("abcdefghijk");

        System.out.println("Password 1: " + p1.getStrength());
        System.out.println("Password 2: " + p2.getStrength());
        System.out.println("Password 3: " + p3.getStrength());
    }
}