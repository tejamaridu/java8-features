package java8;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

    public void logData();

    default void testData(int i, String str) {
        i = 10;
        str = "HELLO";
        System.out.println("Test");
    }

    static void sendData() {
        System.out.println("Send");
    }
}


