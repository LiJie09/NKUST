import java.math.BigDecimal;

public class BMI {
    public static void main(String[] args) {
        int H,w,BMI;
        H = 175;
        H /=100;
        w = 72;
        BMI = w/ (H ^2);
        System.out.println(BMI);
    }
}
