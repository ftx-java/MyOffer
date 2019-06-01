package tx.offer;

/**
 * 第48题
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，
 * 最长非重复子字符串为”acfr”，长度为4。
 *
 * @author tx
 * @date 2018/05/09
 */
public class Test48 {
    public int maxLength(String str){
        if(str==null||str.length()<=0){
            return 0;
        }
        //f(i-1)
        int preLength = 0;
        //f(i)
        int curLength = 0;
        int maxLength = 0;
        //用于存放字母上次出现的位置
        int[] pos = new int[26];
        for(int i=0;i<pos.length;i++){
            //初始位置为-1
            pos[i] = -1;
        }
        for(int i=0;i<str.length();i++){
            int letterNumber = str.charAt(i)-'a';
            if(pos[letterNumber]<0||i-pos[letterNumber]>preLength){
                curLength=preLength+1;
            }else {
                curLength=i-pos[letterNumber];
            }
            pos[letterNumber]=i;
            if(curLength>maxLength){
                maxLength=curLength;
            }
            preLength = curLength;
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        Test48 test48 = new Test48();
        test48.maxLength("arabcacfr");
    }
}
