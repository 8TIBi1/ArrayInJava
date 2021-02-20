package Array;

import java.util.Scanner;

public class NumToRMB {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the price: ");
        var price = input.nextLine();
//        System.out.println(price);

        Convert(price);
    }

    static void Convert(String str) {

        char[] templateChar = {' ', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
/*
*   这一部分未用到，就当作大写参考了。
*
*        char[] preDigit = {' ', '万', '仟', '佰', '拾', '元'};
*        char[] postDigit = {'角', '分'};
*
*/
        int dotPos = str.indexOf(".");

        String preString = str.substring(1, dotPos);
        char[] preChar = preString.toCharArray();

        char[] preConChar = new char[preChar.length];
        for(int i = 0; i < preChar.length; i++) {
            int num = Integer.parseInt(String.valueOf(preChar[i]));
            preConChar[i] = templateChar[num];
        }

        String preConString = String.valueOf(preConChar);
//        System.out.println("preOutString: " + preConString);

        StringBuffer preStrBuf = new StringBuffer(preConString);

        char[] newPreChar = new char[preChar.length + 5];
        int len = newPreChar.length;
        int size = preConChar.length;
        if(preChar.length >= 5) {
            newPreChar[len - 1] = '元';
            newPreChar[len - 2] = preConChar[size - 1];
            newPreChar[len - 3] = '拾';
            newPreChar[len - 4] = preConChar[size - 2];
            newPreChar[len - 5] = '佰';
            newPreChar[len - 6] = preConChar[size - 3];
            newPreChar[len - 7] = '仟';
            newPreChar[len - 8] = preConChar[size - 4];
            newPreChar[len - 9] = '万';
            for(int i = 0; i < (size - 4); i++) {
                newPreChar[i] = preConChar[i];
            }
            preStrBuf = new StringBuffer(String.valueOf(newPreChar));

        }
        else {
            preStrBuf = new StringBuffer(String.valueOf(preConChar));

            if(preStrBuf.length() == 4) {
                preStrBuf.insert(1, '仟');
                preStrBuf.insert(3, '佰');
                preStrBuf.insert(5, '拾');
                preStrBuf.insert(7, '元');
            }
            else if(preStrBuf.length() == 3) {
                preStrBuf.insert(1, '佰');
                preStrBuf.insert(3, '拾');
                preStrBuf.insert(5, '元');
            }
            else if(preStrBuf.length() == 2) {
                preStrBuf.insert(1, '拾');
                preStrBuf.insert(3, '元');
            }
            else if(preStrBuf.length() == 1) {
                preStrBuf.insert(1, '元');
            }
        }




        String postString = str.substring(dotPos + 1);
//        System.out.println("postString: " + postString);
        char[] postChar = postString.toCharArray();

        char[] postConChar = new char[postChar.length];
        for(int i = 0; i < postChar.length; i++) {
            int num = Integer.parseInt(String.valueOf(postChar[i]));
            postConChar[i] = templateChar[num];
        }

        String postConString = String.valueOf(postConChar);
//        System.out.println("postOutString: " + postConString);

        StringBuffer postStrBuf = new StringBuffer(postConString);
        if(postStrBuf.length() > 1) {
            postStrBuf.insert(1, '角');
            postStrBuf.insert(3, '分');
        }
        else {
            postStrBuf.insert(1, '角');
        }
//        System.out.println("postStrBuf: " + postStrBuf);

        StringBuffer output = new StringBuffer();
        output = preStrBuf.append(postStrBuf);
        System.out.println(output);
    }
}
