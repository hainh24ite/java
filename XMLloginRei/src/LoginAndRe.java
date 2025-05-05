import java.util.ArrayList;
import java.util.List;

public class LoginAndRe {

    private List<User> list=new ArrayList<>();

    public LoginAndRe() {}

    public void Rei(String tdn, int tuoi,String ten,String pwd) {
        list.add(new User(ten,tdn,Hash.hash(pwd),tuoi));
        System.out.println("them thanh cong");
    }

    public boolean Login(String tdn,String pw) {
        for(User user:list) {
            if(user.getTnd().equals(tdn)) {
                if(Hash.verify(pw,user.getMkbcrypt())) {
                    System.out.println("thanh cong");
                    return true;
                }else{
                    System.out.println("that bai");
                    return false;
                }
            }
        }
        System.out.println("that bai");
        return false;
    }

    public List<User> getAllUsers() {
        return list;
    }
}
