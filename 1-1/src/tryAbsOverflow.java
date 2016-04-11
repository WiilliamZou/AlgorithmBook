/**
 * Created by yunxiaozou on 3/27/16.
 */
public class tryAbsOverflow {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648));
        System.out.println(Math.abs(-2147483647));
        System.out.println(Double.POSITIVE_INFINITY == (Double.POSITIVE_INFINITY + 1233.0));
        System.out.println(Double.NEGATIVE_INFINITY == (Double.NEGATIVE_INFINITY - 1233.0));
        System.out.println(Double.POSITIVE_INFINITY == (Double.POSITIVE_INFINITY - 1233.0));
        System.out.println(Double.NEGATIVE_INFINITY == (Double.NEGATIVE_INFINITY + 1233.0));
    }
}
