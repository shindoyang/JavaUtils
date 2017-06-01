package shindo.Java;

public class StringTest {
    public static void main(String[] args) {
        /*String str = "D168//1QrCkfu6m4+4BEKUG3p4QXumm4nTGlwJX09bMZR7U1u63MC1FkOq4BZQkbdwsVTnOpX8LC/9kkvNioCfPfpD+omMdYY0kWdVzHRozpWPkqpD/e04hes78GZGlyeUiOfxgIfVNkERbb2Opaf17+7OUjq0U9EXoCsxqrSNxkyYoBaj5L7lC+y7frFoj9hYLAeICyyBXcQboE804rZdMiLkeJhNk4g+PLZbDLhtZJW0LagM8JV/zq2QGYB+xHKMAKpJ7uoty1bmcXmbgQMPxyEF51xUbBeckJCvP7JVhkVN9Ig9o5flSgRIK9UVcGbcOmr9mLwnAuiiIrnjfSlA==";
        System.out.println(str.length());*/

        /*String url = "https://www.test.com";
        System.out.println(url);
        url = url.substring(5);
        url = "http" + url;
        System.out.println(url); */

        /*String md5key = "10561eb87e534930b9d8b37ed46d778a";
        System.out.println(md5key.length());*/

        String pimg = "https://www.123.com";
        if (pimg.contains("https")) {
            pimg = "http" + pimg.substring(5);
            System.out.println(pimg);
        }

        /*String v = "YjlmM2NjNjhhMmJhYjUyMWRjOWNmMzNkZDM2YzhmMzU3OTU4NjRkZjViNjcwNWY2NzkwOGMwNzRkMTJjM2FjMw==";
        System.out.println(v.length());*/

    }
}
