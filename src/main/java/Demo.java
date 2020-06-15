import java.util.ArrayList;
import java.util.List;

public class Demo {


    /**
     *
     */
    public static void main(String[] agrs){
     main();
    }




    public static void main () {

            List<User> userList = new ArrayList<User>(-1);
             userList.add(new User());
        }




    public static int fun1(int m,int n) {
        if (m > n || m >= 1000000000 || n >= 1000000000) {
            System.out.println("no");
            return -1;
        }
        int num = 0;
        for (int i = m; i <= n; i++) {
            if (i % 7 == 0 && i % 4 != 0) {
                num = num > i ? num : i;
            }
        }

        return num;
    }
}
class User{

    private int age;

    /**
     * 1男 0女
     */
    private int sex;

    public User(){

    }
}