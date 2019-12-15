package manage.com.test;

public class T {
public static void main(String[] args) {
    double d1 = 15;
    double d2 = 10;

    double result = d1 / d2;

    /**
     * 四舍五入
     */
    int roundNum = (int) Math.round(result);
    /**
     * 向上取整
     */
    int ceilNum = (int) Math.ceil((double)15/10);
    /**
     * 向下取整
     */
    int floorNum = (int) Math.floor(result);

    System.out.println("除法商值：" + result);
    System.out.println("四舍五入：" + roundNum);
    System.out.println("向上取整：" + ceilNum);
    System.out.println("向下取整：" + floorNum);
}
}
