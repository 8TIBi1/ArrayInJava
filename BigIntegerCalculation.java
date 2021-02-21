package Array;

public class BigIntegerCalculation {

    public static void main(String[] args) {

//        BigIntegerInArray s1 = new BigIntegerInArray("999999999");
//        BigIntegerInArray s2 = new BigIntegerInArray("999999999");
//        String res = s1.addition(s1, s2);
//        System.out.println("Sum: " + res);
//
//        BigIntegerInArray sb1 = new BigIntegerInArray("123456789");
//        BigIntegerInArray sb2 = new BigIntegerInArray("2223456789");
//        String sub = sb1.subtraction(sb1, sb2);
//        System.out.println("Subtraction: " + sub);

        BigIntegerInArray mul1 = new BigIntegerInArray("99999");
        BigIntegerInArray mul2 = new BigIntegerInArray("99999");
        String mul = mul1.Multiplication(mul1, mul2);
        System.out.println("Multiplication: " + mul);


    }

}

class BigIntegerInArray {

    char[] val;

    public BigIntegerInArray(String str) {
        this.val = str.toCharArray();
    }

    public String ToString(BigIntegerInArray s) {
        return String.valueOf(s.val);
    }

    String addition(BigIntegerInArray num1, BigIntegerInArray num2) {

        String str1 = num1.ToString(num1);
        String str2 = num2.ToString(num2);

        if(str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        char[] x = new char[c1.length];
        char[] y = new char[c1.length];

        for(int i = 0; i < c1.length; i++) {
            x[i] = c1[c1.length - 1 - i];
        }

        for(int i = 0; i < c1.length; i++) {
            if(i < c2.length)
                y[i] = c2[c2.length - 1 - i];
            else {
                y[i] = 48;
            }
        }



        int c = 0; // 存储进位
        char[] s = new char[c1.length + 1]; // 存储当前位的值

        int hi = 0;
        for(int i = 0; i < x.length; i++) {
            int n1 = Integer.parseInt(String.valueOf(x[i]));
            int n2 = Integer.parseInt(String.valueOf(y[i]));
            int sum = n1 + n2 + c;
            c = sum / 10;  // 计算进位
//            System.out.println("c: " + c);
            s[i] = (char) (sum % 10 + 48);  // 计算当前位的值
//            System.out.println("s[" + i + "]" + s[i]);

            if(i == (x.length - 1) && c != 0) {
                hi = s.length - 1;
                s[hi] = (char) (c + 48);
            }
        }


        char[] res = new char[s.length];

        for(int i = 0; i < s.length; i++) {
            res[i] = s[s.length - 1 - i];
        }

        String result = String.valueOf(res);

        return result;
    }


    String subtraction(BigIntegerInArray num1, BigIntegerInArray num2) {

        String str1 = num1.ToString(num1);
        String str2 = num2.ToString(num2);

        // 比较输入的两个数的大小，保证 被减数 > 减数
        if(str1.equals(str2)) {
            return String.valueOf('0');
        }

        int minus = 0; // 标记结果是否为负数，minus = 1 则结果为负数，结果前就需要加上负号
        if(str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
            minus = 1;
        }
        else if(str1.length() == str2.length()) {
            int len = str1.length();
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();

            for(int i = 0; i < len; i++) {
                if(s1[i] < s2[i]) {
                    minus = 1;
                }
                else if(s1[i] >= s2[i]){
                    minus = 0;
                }
            }
        }

        // 翻转数字
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        char[] ch1 = new char[c1.length];
        for(int i = 0; i < c1.length; i++) {
            ch1[i] = c1[c1.length - 1 - i];
        }

        char[] ch2 = new char[c1.length];
        for(int i = 0; i < c1.length; i++) {
            if(i < c2.length)
                ch2[i] = c2[c2.length - 1 - i];
            else
                ch2[i] = 48;
        }

        int m = 0; // 表示是否借位
        int[] s = new int[c1.length]; // 存储每一位的相减的结果
        // 进行逐位减法运算
        final int mod = 10;
        for(int i = 0; i < c1.length; i++) {
            int n1 = Integer.parseInt(String.valueOf(ch1[i]));
            int n2 = Integer.parseInt(String.valueOf(ch2[i]));
            if(ch1[i] < ch2[i]) {
                s[i] = n1 + mod - n2 - m;
                m = 1;
            }
            else {
                s[i] = n1  - n2 - m;
                m = 0;
            }

        }

        char[] res = new char[c1.length + 1];;
        if(minus == 0) {
            for(int i = 0; i < c1.length; i++) {
                res[i] = (char) (s[c1.length - 1 - i] + 48);
            }
        }
        else {
            res[0] = '-';
            for(int i = 1; i <= c1.length; i++) {
                res[i] = (char) (s[c1.length - i] + 48);
            }
        }

        String result = String.valueOf(res);
//        System.out.println(result);
        return result;
    }


    String Multiplication(BigIntegerInArray num1, BigIntegerInArray num2) {

        String str1 = num1.ToString(num1);
        String str2 = num2.ToString(num2);

        int length1 = str1.length();
        int length2 = str2.length();
        int max = 0;
        if(length1 < length2) {
            max = length2;
        }
        else {
            max = length1;
        }

        if(max <= 4) {
            int i1 = Integer.parseInt(str1);
            int i2 = Integer.parseInt(str2);
            int res = i1 * i2;
            String resString = String.valueOf(res);
            return resString;
        }

        if(str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        int len1 = str1.length();
        int len2 = str2.length();
        char[] n1 = new char[len1];
        char[] ch1 = str1.toCharArray();
        char[] n2 = new char[len2];
        char[] ch2 = str2.toCharArray();

        for(int i = 0; i < len1; i++) {
            n1[i] = ch1[len1 - 1 - i];
        }

        for(int i = 0; i < len2; i++) {
            n2[i] = ch2[len2 - 1 - i];
        }

        int i2, j1;
        int c = 0;
        int[] s = new int[len1 + len2 + 1];
        for(i2 = 0; i2 < len2; i2++) {
            for(j1 = 0; j1 < len1; j1++) {
                int number1 = Integer.parseInt(String.valueOf(ch1[j1]));
                int number2 = Integer.parseInt(String.valueOf(ch2[i2]));
                int mul = number1 * number2;
                int tmpSum = mul + c;
                s[i2 + j1] += tmpSum % 10;
                System.out.print("s[" + i2 + "][" + j1 + "]: " + s[i2 + j1] + " ");

                c = (mul + c) / 10;
                System.out.print("c: " + c + " ");
//                if(i == 0 && j == 1) {
//                    System.out.println("i = 0, j = 1, mul: " + mul + " tmpSum: " + tmpSum + " s[1]: " + s[1] + " c:" + c);
//                }
//
//                if(i == 1 && j == 0) {
//                    System.out.println("i = 1, j = 0, mul: " + mul + " tmpSum: " + tmpSum + " s[1]: " + s[1] + " c:" + c);
//                }

            }
            s[i2 + j1 + 1] = c;
            c = 0;
        }

        System.out.println();
        for(int i = 0; i < s.length; i++) {
            System.out.print("s[" + i + "]: " + s[i] + " ");
        }
        System.out.println();

        final int size = len1 + len2;
        int[] newS = new int[size];
        int nec = 0;
        for(int i = 0; i < size; i++) {
            int tmp = s[i] + nec;
            newS[i] = tmp % 10;
            nec = tmp / 10;
        }
        for(int i = 0; i < size; i++) {
            System.out.print("newS[" + i + "]: " + newS[i] + " ");
        }
        System.out.println();

        char[] res = new char[size];
//        for(int i = 0; i < size; i++) {
//            res[i] = (char) (s[size - 1 - i] + 48);
//        }

//        String result = String.valueOf(res);
//        return result;
        String tmpResult = String.valueOf(1);
        return tmpResult;
    }


//    String Factor(BigIntegerInArray number) {
//
//        String num = number.ToString(number);
//
//
//
//    }


}
