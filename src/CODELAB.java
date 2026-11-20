import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class CODELAB {
    public static void main(String[] args) {

        //PIDO NOMBRE POR TECLADO
        Scanner scan = new Scanner(System.in);
        System.out.println("Cómo se llama tu héroe");
        String name = scan.nextLine();

        //DECLARO CONSTANTES PARA LOS NIVELES
        int hp = 100;
        int potion = 2;
        final int DAÑO_ESPADA = 25;

        //VALORES DE LOS ENEMIGOS
        //====TRASGO====
        final int VIDA_TRASGO = 50;
        final int DANIO_MAX_TRASGO = 20;
        //====TROLL====
        final int DANIO_MIN_TROLL = 80;
        final int DANIO_MAX_TROLL = 30;



        //IMPRIMO DATOS PJ
        System.out.println("¡Bienvenido, " + name + "!");
        System.out.println("Vida: " + hp);
        System.out.println("Pociones: " + potion);

        //DECLARO RANDOM
        Random random = new Random();

        //CONTADOR ENEMIGOS SUPERADOS
        int enemigosSuperados = 0;

        //INICIALIZO EL BUCLE
        while(hp > 0) {

            //AÑADO DIVERSOS TIPOS DE ENEMIGO + CALCULO DEL DAÑO
            int tipoEnemigo = random.nextInt(2) + 1;
            int golpeEnemigo = 0;

            switch(tipoEnemigo) {
                case 1:
                    System.out.println("Aparece un Trasgo...");
                    System.out.println("=== TRASGO ===");
                    golpeEnemigo = random.nextInt(DANIO_MAX_TRASGO - DANIO_MIN_TRASGO + 1) + DANIO_MIN_TRASGO;
                    break;
                case 2:
                    System.out.println("Aparece un troll...");
                    System.out.println("=== TROLL ===");
                    golpeEnemigo = random.nextInt(DANIO_MAX_TROLL - DANIO_MIN_TROLL + 1) + DANIO_MIN_TROLL;
                    break;
            }

            //APLICO DAÑO DEL ENEMIGO
            hp = Math.max(0, hp - golpeEnemigo);
            System.out.println("El enemigo te ataca!");
            System.out.println("Daño recibido " + golpeEnemigo);
            System.out.println("Has recibido un buen golpe!");
            if(hp > 0) {
                enemigosSuperados++;
            }

            //COMPROBACION DE HP + USO DE POCIONES PARA LA CURA
            System.out.println("Vida: " + hp);
            System.out.println("Pociones: " + potion);

            if(hp >= 1 && hp <= 19) {
                System.out.println("¡Vida critica!");
                if(potion > 0) {
                    potion--;
                    hp = 50;
                    System.out.println("Has usado una pocion!");
                    System.out.println("vida: " + hp);
                    System.out.println("Pociones: " + potion);
                } else {
                    System.out.println("No te quedan Pociones");
                }
            } else if(hp <= 0) {
                System.out.println("has sido derrotado...");
                System.out.println("GAME OVER");
            }
        }
        System.out.println("ENEMIGOS SUPERADOS: " + enemigosSuperados);
        scan.close();
    }
}