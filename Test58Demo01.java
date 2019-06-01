package tx.offer;

/**
 * 第58 第1题
 * 翻转单词顺序序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author tx
 * @date 2018/05/14
 */
public class Test58Demo01 {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            if (i != 0) {
                sb.append(s[i]);
                sb.append(" ");
            } else {
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "student. a am I";
        String str1 = " ";
        Test58Demo01 test58Demo01 = new Test58Demo01();
        test58Demo01.ReverseSentence(str1);
    }
}
