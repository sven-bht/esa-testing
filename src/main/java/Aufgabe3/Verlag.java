package Aufgabe3;

public class Verlag {
    public static int berechne(String s) {
        if (s == null) {
            throw new RuntimeException();
        }
        return s.length() / 10;
    }
}
