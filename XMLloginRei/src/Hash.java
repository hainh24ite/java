import org.mindrot.jbcrypt.BCrypt;

public class Hash {
    public static String hash(String str) {
        String hashed= BCrypt.hashpw(str, BCrypt.gensalt());
        return hashed;
    }

    public static boolean verify(String pw, String hashed) {
        return BCrypt.checkpw(pw, hashed);
    }
}
