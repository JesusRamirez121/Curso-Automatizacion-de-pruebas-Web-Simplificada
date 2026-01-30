package utils;

public class EsperaUtil {
    private EsperaUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
