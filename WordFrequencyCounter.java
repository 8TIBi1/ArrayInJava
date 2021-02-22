package Array;

import java.util.List;
import java.io.*;
import java.util.*;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\JavaProjects\\HelloJava\\src\\Array\\text.txt");
//        if(file.isFile()) {
//            System.out.println("文件");
//            System.out.print(file.canRead() ? "可读" : "不可读");
//            System.out.print(file.canWrite() ? "可写" : "不可写");
//            System.out.println(file.length() + "字节");
//        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String tmpString = null;
        int line = 1;
        Map<String, Integer> words = new HashMap<>();
        StringBuffer buf = new StringBuffer();
        while((tmpString = br.readLine()) != null) {
            if(tmpString.equals("")) {
                tmpString = br.readLine();
            }
            StringTokenizer tokens = new StringTokenizer(tmpString, " ,.!\\?''\n():\"“");

            while(tokens.hasMoreTokens()) {
//                buf.append(tokens.nextToken() + " ");
                String word = tokens.nextToken();
                if(!words.containsKey(word)) {
                    words.put(word, 1);
                }
                else {
                    int k = words.get(word) + 1;
                    words.put(word, k);
                }
            }
//            System.out.println("Line" + line + ": " + tmpString);
//            System.out.println(buf.toString());
            line++;
            buf.delete(0, buf.length());
        }

//        // 迭代器遍历输出words未排序内容
//        Iterator it = words.keySet().iterator();
//        while(it.hasNext()) {
//            String w = (String) it.next();
//            System.out.println(w + ":\t" + words.get(w));
//        }

        // 排序部分参考的博客地址：https://www.jianshu.com/p/61f6516108d9
        //                    https://www.cnblogs.com/chenchen127/p/12169904.html
        // 排序开始，重写compare()方法（比较器），使得按照value从大到小排序
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        // 先将HashMap的entrySet()转换为List。这里要注意import的是util的List，不是awt的List(虽然是自动引的)，
        // 否则会报错，需要手动改正。
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(words.entrySet());
        // 对words按value从大到小排序。
        Collections.sort(list, valueComparator);

        System.out.println("Rank" + "\t" + "Word" + "\t" + "Frequency");
        int cnt = 0;
        for(Map.Entry<String, Integer> entry: list) {
            if(cnt < 10) {
                System.out.println((cnt + 1) + "\t\t" + entry.getKey() + "\t\t" + entry.getValue());
                cnt++;
            }
        }

    }

}
