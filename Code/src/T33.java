import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: zhangxin
 * Time: 2016/11/23 0023.
 * Desc:将数组中的数拼接成最小的数
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * 3 32 > 32 3 说明:32小,即 a+b > b+a => a>b
 */
public class T33 {
    public String PrintMinNumber(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = (o1 + o2).compareTo(o2 + o1);
                if (res > 0) {
                    return 1;
                } else if (res < 0) {
                    return -1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T33 t = new T33();
        int[] a = {3,32,321};
        System.out.println(t.PrintMinNumber(a));
    }
}
