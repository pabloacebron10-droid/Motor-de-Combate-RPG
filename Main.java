import java.util.Scanner;

import interfaces.Atacar;
import interfaces.AtacarYCurar;
import interfaces.Curar;
import personajes.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenidos al juego de combate por equipos ===\n");

        // Elección de equipos
        System.out.println("Jugador 1: Elige tus 2 personajes");
        Personaje[] equipo1 = crearEquipo(sc);

        System.out.println("\nJugador 2: Elige tus 2 personajes");
        Personaje[] equipo2 = crearEquipo(sc);

        System.out.println("\n¡Comienza la batalla!\n");

        boolean turnoJugador1 = true;

        while(existeVivo(equipo1) && existeVivo(equipo2)) {
            Personaje[] equipoAtacante = turnoJugador1 ? equipo1 : equipo2;
            Personaje[] equipoDefensor = turnoJugador1 ? equipo2 : equipo1;

            System.out.println("\n=== Turno del Jugador " + (turnoJugador1 ? "1" : "2") + " ===");
            mostrarEstado(equipo1, equipo2);

            // Elegir atacante
            Personaje atacante = elegirPersonajeVivo(sc, equipoAtacante, "elige personaje para actuar:");

            // Elegir acción
            if(atacante instanceof AtacarYCurar) {
                System.out.println("1. Atacar");
                System.out.println("2. Curar");
                System.out.print("Elige acción: ");
                int accion = sc.nextInt();
                sc.nextLine();

                if(accion == 1){
                    Personaje defensor = elegirPersonajeVivo(sc, equipoDefensor, "elige personaje enemigo a atacar:");
                     ((Atacar) atacante).atacar(defensor);
                } else {
                    Personaje objetivoCurar = elegirPersonajeVivo(sc, equipoAtacante, "elige personaje a curar:");
                    ((Curar) atacante).curar(objetivoCurar);
                }
            } else {
                Personaje defensor = elegirPersonajeVivo(sc, equipoDefensor, "elige personaje enemigo a atacar:");
                     ((Atacar) atacante).atacar(defensor);
            }

            turnoJugador1 = !turnoJugador1;
        }

        // Resultado final
        System.out.println("\n=== Batalla finalizada ===");
        if(existeVivo(equipo1)) {
            System.out.println("¡¡Jugador 1 gana!!");
        } else {
            System.out.println("¡¡Jugador 2 gana!!");
        }

        mostrarEstado(equipo1, equipo2);
        sc.close();
    }

    private static Personaje[] crearEquipo(Scanner sc) {
        Personaje[] equipo = new Personaje[2];
        for(int i=0; i<2; i++){
            System.out.println("\nPersonaje " + (i+1) + ":");
            equipo[i] = elegirPersonaje(sc);
        }
        return equipo;
    }

    private static Personaje elegirPersonaje(Scanner sc){
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Paladín");
        System.out.println("4. Clérigo");
        System.out.print("Elige opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.print("Escribe el nombre de tu personaje: ");
        String nombre = sc.nextLine();

        switch(opcion){
            case 1: return new Guerrero(nombre, 1);
            case 2: return new Mago(nombre, 1);
            case 3: return new Paladin(nombre, 1);
            case 4: return new Clerigo(nombre, 1);
            default:
                System.out.println("Opción inválida, se asigna Guerrero por defecto.");
                return new Guerrero(nombre, 1);
        }
    }

    private static Personaje elegirPersonajeVivo(Scanner sc, Personaje[] equipo, String mensaje){
        while(true){
            System.out.println(mensaje);
            for(int i=0; i<equipo.length; i++){
                Personaje p = equipo[i];
                String estado = p.getPuntosDeVida() > 0 ? p.getPuntosDeVida() + " ps" : "DEBILITADO";
                System.out.println((i+1) + ". " + p.getClass().getSimpleName() + " " + p.getNombre() + " (" + estado + ")");
            }
            int sel = sc.nextInt() - 1;
            sc.nextLine();
            if(sel >=0 && sel < equipo.length && equipo[sel].getPuntosDeVida() > 0){
                return equipo[sel];
            } else {
                System.out.println("Selección inválida o personaje debilitado. Intenta de nuevo.");
            }
        }
    }

    private static boolean existeVivo(Personaje[] equipo){
        for(Personaje p : equipo){
            if(p.getPuntosDeVida() > 0) return true;
        }
        return false;
    }

    private static void mostrarEstado(Personaje[] equipo1, Personaje[] equipo2){
        System.out.println("\n--- Estado de los equipos ---");
        System.out.println("Jugador 1:");
        for(Personaje p : equipo1){
            String estado = p.getPuntosDeVida() > 0 ? p.getPuntosDeVida() + " ps" : "DEBILITADO";
            System.out.println("- " + p.getClass().getSimpleName() + " " + p.getNombre() + " (" + estado + ")");
        }
        System.out.println("Jugador 2:");
        for(Personaje p : equipo2){
            String estado = p.getPuntosDeVida() > 0 ? p.getPuntosDeVida() + " ps" : "DEBILITADO";
            System.out.println("- " + p.getClass().getSimpleName() + " " + p.getNombre() + " (" + estado + ")");
        }
        System.out.println("----------------------------");
    }
}