package creational.singleton;

public class SingletonJava {
    private static SingletonJava instance;
    private final String value;

    // private constructor
    private SingletonJava(String value) {
        this.value = value;
    }

    // method to get instance
    public static SingletonJava getInstance(String value) {
        if (instance == null) {
            instance = new SingletonJava(value);
        }
        return instance;
    }

    public void someFunction() {
        System.out.println("SingletonJava: printing value: " + value);
    }
}