package tx.offer;

/**
 * 第5题
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author tx
 * @date 2019/02/28
 */
public class Test05 {
    public String replaceSpace(StringBuffer str) {
        int num = str.length();
        int lengthA = str.length() - 1;

        if (str == null) {
            return null;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                num += 2;
            }
        }
        str.setLength(num);
        int lengthB = num - 1;

        for (int i = lengthA; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(lengthB--, str.charAt(i));
            } else {
                str.setCharAt(lengthB--, '0');
                str.setCharAt(lengthB--, '2');
                str.setCharAt(lengthB--, '%');
            }
        }

        System.out.println(str.toString());
        return str.toString();
    }

    public static void main(String[] args) {
        Test05 test05 = new Test05();
        StringBuffer str = new StringBuffer("we are happy. ");
        test05.replaceSpace(str);
    }
}
