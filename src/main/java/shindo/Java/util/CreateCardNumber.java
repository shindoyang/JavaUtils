package shindo.Java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class CreateCardNumber {

    // 西洋街卡片编码前缀
    private static final String[] XYJ_PREFIX_LIST = new String[] { "6" };

    // 制卡批次号
    private static final String[] BATCH_PREFIX_LIST = new String[] { "002" };

    // 发售区域号
    private static final String[] REGION_PREFIX_LIST = new String[] { "0756" };

    /**
     * 序列倒置
     * @param str
     * @return
     */
    private static String strrev(String str) {
        if (str == null) {
            return "";
        }
        String revstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revstr += str.charAt(i);
        }
        return revstr;
    }

    /**
     * 生产卡号
     * @param prefix
     * @param length
     * @return
     */
    private static String completed_number(String prefix, int length) {
        String ccnumber = prefix;
        // 产生卡序列
        while (ccnumber.length() < (length - 1)) {
            ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
        }
        // 数据转换
        String reversedCCnumberString = strrev(ccnumber);

        List<Integer> reversedCCnumberList = new Vector<Integer>();
        for (int i = 0; i < reversedCCnumberString.length(); i++) {
            reversedCCnumberList.add(new Integer(String.valueOf(reversedCCnumberString.charAt(i))));
        }
        // 计算总合数
        int sum = 0;
        int pos = 0;
        Integer[] reversedCCnumber = reversedCCnumberList.toArray(new Integer[reversedCCnumberList.size()]);
        while (pos < length - 1) {
            int odd = reversedCCnumber[pos] * 2;
            if (odd > 9) {
                odd -= 9;
            }
            sum += odd;
            if (pos != (length - 2)) {
                sum += reversedCCnumber[pos + 1];
            }
            pos += 2;
        }
        // 添加数字校验位
        int checkdigit = new Double(((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
        ccnumber += checkdigit;
        return ccnumber;
    }

    /**
     * 随机获取标示位
     * @param xyjPrefixList
     * @param batchPrefixList
     * @param length
     * @param howMany
     * @return
     */
    private static String[] credit_card_number(String[] xyjPrefixList, String[] batchPrefixList, String[] regionPrefixList, int length, int howMany) {
        Stack<String> result = new Stack<String>();
        for (int i = 0; i < howMany; i++) {
            // 随机取西洋街卡片编码前缀
            int xyjRandomArrayIndex = (int) Math.floor(Math.random() * xyjPrefixList.length);
            int batchRandomArrayIndex = (int) Math.floor(Math.random() * batchPrefixList.length);
            int regionRandomArrayIndex = (int) Math.floor(Math.random() * regionPrefixList.length);
            String ccnumber = xyjPrefixList[xyjRandomArrayIndex] + batchPrefixList[batchRandomArrayIndex] + regionPrefixList[regionRandomArrayIndex];
            result.push(completed_number(ccnumber, length));
        }

        return result.toArray(new String[result.size()]);
    }

    public static String[] generateXyjCardNumbers(int howMany) {
        return credit_card_number(XYJ_PREFIX_LIST, BATCH_PREFIX_LIST, REGION_PREFIX_LIST, 16, howMany);
    }

    /**
     * 校验卡位
     * @param creditCardNumber
     * @return
     */
    private static boolean isValidCreditCardNumber(String creditCardNumber) {
        boolean isValid = false;
        try {
            String reversedNumber = new StringBuffer(creditCardNumber).reverse().toString();
            int mod10Count = 0;
            for (int i = 0; i < reversedNumber.length(); i++) {
                int augend = Integer.parseInt(String.valueOf(reversedNumber.charAt(i)));
                if (((i + 1) % 2) == 0) {
                    String productString = String.valueOf(augend * 2);
                    augend = 0;
                    for (int j = 0; j < productString.length(); j++) {
                        augend += Integer.parseInt(String.valueOf(productString.charAt(j)));
                    }
                }
                mod10Count += augend;
            }
            if ((mod10Count % 10) == 0) {
                isValid = true;
            }
        } catch (NumberFormatException e) {
            System.err.println("Data verification error.");
        }

        return isValid;
    }

    /**
     * 生成新的卡片数据
     */
    public static List createNewCards(int cardNums) {
        String[] newCardsMap = generateXyjCardNumbers(cardNums);
        List newCards = new ArrayList();
        for (int i = 0; i < newCardsMap.length; i++) {
            newCards.add(newCardsMap[i]);
        }
        return newCards;
    }

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static List txt2String(File file) {
        List list = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                s = s.replaceAll("come,", "");
                s = s.replaceAll(",back", "");
                list.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 自身排重 
     */
    public static List checkRepect(List target) {

        List back = new ArrayList();
        for (int k = 0; k < target.size(); k++) {
            boolean repect = false;
            String temp = (String) target.get(k);
            int count = 0;
            for (int j = 0; j < target.size(); j++) {
                String temp2 = (String) target.get(j);
                if (temp.equals(temp2)) {
                    count++;
                }
                if (count >= 2) {
                    repect = true;
                }
            }
            if (!repect) {
                back.add(temp);
            }
        }
        return back;
    }

    /**
     * 与制定对象排重 
     */
    public static List checkRepect(List newCards, List oldCards) {

        List back = new ArrayList();
        for (int k = 0; k < newCards.size(); k++) {
            boolean repect = false;
            String temp = (String) newCards.get(k);
            int count = 0;
            for (int j = 0; j < oldCards.size(); j++) {
                String temp2 = (String) oldCards.get(j);
                if (temp.equals(temp2)) {
                    count++;
                }
                if (count >= 1) {
                    repect = true;
                }
            }
            if (!repect) {
                back.add(temp);
            }
        }
        return back;
    }

    /**
     * 补充不足的卡
     */
    public static List createLessCard(int lessNum, List newCards, List oldCards) {
        // 生成新卡
        List lessCards = createNewCards(lessNum);

        // 新卡自身排重
        lessCards = checkRepect(lessCards);

        List allUsedCards = new ArrayList();
        allUsedCards.addAll(oldCards);
        allUsedCards.addAll(newCards);

        // 与已生成的卡片排重
        lessCards = checkRepect(lessCards, allUsedCards);

        newCards.addAll(lessCards);

        int less = lessNum - lessCards.size();
        while (less > 0) {
            newCards = createLessCard(less, newCards, oldCards);
        }

        return newCards;

    }

    /**
     * 将生成卡号写入txt文本
     */
    public static void writeTxt(String fileName, List cardList) {
        try {
            /* 写入Txt文件 */
            File writename = new File(fileName); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (int i = 0; i < cardList.size(); i++) {
                out.write(cardList.get(i) + "\r\n"); // \r\n即为换行
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
            System.out.println("卡片信息写入    " + fileName + "  成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, String> orginMap = new HashMap<String, String>();
        // 获取以往的卡片记录
        List oldCards = txt2String(new File("D:/test/oldCard.txt"));

        // 生成新的卡片数据
        int targetNums = 3;// 新卡片数
        List newCards = createNewCards(targetNums);

        // 新卡自身排重
        newCards = checkRepect(newCards);

        // 新卡与旧卡排重
        if (oldCards.size() > 0) {
            newCards = checkRepect(newCards, oldCards);
        }

        // 补充去重后不足的
        int lessNum = targetNums - newCards.size();
        createLessCard(lessNum, newCards, oldCards);

        for (int i = 0; i < newCards.size(); i++) {
            System.out.println(newCards.get(i));
        }
        System.out.println("本次制卡数量为：" + newCards.size());

        // 将生成的卡片信息写入txt文本
        String fileName = "D:/test/newCard.txt";
        writeTxt(fileName, newCards);

    }
}
