package lippia.web.utils;

public class Sleep {
    public static void Stop(int second) {
// Pausa de 3 segundos
        try {
            Thread.sleep(second * 1000); // 3000 milisegundos = 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
