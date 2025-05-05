public class User {
    private String name;

    private String tnd;

    private String mkbcrypt;

    private int tuoi;

    public User(String name, String tnd, String mkbcrypt, int tuoi) {
        this.name = name;
        this.tnd = tnd;
        this.mkbcrypt = mkbcrypt;
        this.tuoi = tuoi;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTnd() {
        return tnd;
    }

    public void setTnd(String tnd) {
        this.tnd = tnd;
    }

    public String getMkbcrypt() {
        return mkbcrypt;
    }

    public void setMkbcrypt(String mkbcrypt) {
        this.mkbcrypt = mkbcrypt;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}

