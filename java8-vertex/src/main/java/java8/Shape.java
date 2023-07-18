package java8;

@FunctionalInterface
 interface Shape {

    public void draw(int a, int b);

    default void testData() {
        System.out.println("Test");
    }

    static void sendData() {
        System.out.println("Send");
    }
}
