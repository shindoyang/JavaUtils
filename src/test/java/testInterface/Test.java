package testInterface;

public class Test implements Ifather {
    private String status = "";

    public Test() {
    };

    public Test(String status) {
        System.out.println("comeIn");
        this.status = status;
    }

    public String getStatus() {
        System.out.println(this.status);
        return this.status;
    }

}
