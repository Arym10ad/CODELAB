import java.util.Scanner;

public class SESION1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cómo se llama tu héroe");
        String name = scan.nextLine();
        int hp = 100;
        int potion = 3;

        //selector de dificultad
        System.out.println("Escoje un nivel de dificultad:");
        System.out.println("1 = Fácil | 2 = Normal | 3 = Difícil");
        int dificultad = scan.nextInt();
        switch(dificultad) {
            case 1:
                hp = 150;
                System.out.println("Dificultad: Fácil");
                break;
            case 2:
                hp = 100;
                System.out.println("Dificultad: Normal");
                break;
            case 3:
                hp = 50;
                System.out.println("Dificultad: Díficil");
                break;
            default:
                System.out.println("Valor no valido");
                break;
        }
        //Imprimo datos iniciales
        System.out.println("¡Bienvenido, " + name + "!");
        System.out.println("Vida: " + hp);
        System.out.println("Pociones: " + potion);

        //Resto a la vida el daño del Trasgo
        int danoTrasgo = 85;
        hp -= danoTrasgo;
        System.out.println("Trasgo te asesta un golpe!");
        System.out.println("Vida: " + hp);
        System.out.println("Pociones: " + potion);
        System.out.println("Has recibido un buen golpe!");
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
}