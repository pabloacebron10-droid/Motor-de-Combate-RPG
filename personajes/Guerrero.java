package personajes;

import interfaces.Atacar;

public class Guerrero extends Personaje implements Atacar {

    public Guerrero(String nombre, int nivelActual){
        super(nombre, nivelActual, 20);
    }

    @Override
    public void atacar(Personaje objetivo) {
        this.gritoDeBatalla();
        objetivo.recibirDaño(this);
    }

    @Override
    protected void recibirDaño(Personaje atacante) {

        int daño = atacante.getAtaque();
        this.setPuntosDeVida(this.getPuntosDeVida() - daño);

        mensajeDeDaño(atacante);

        if(this.getPuntosDeVida()<=0){
            System.out.println("Guerrero " + this.getNombre() + ": ¡Agggghhhh!\nEl guerrero "+ this.getNombre() + " ha sido debilitado...  0/100 ps");
        }else if(this.getPuntosDeVida() <= 25){
            System.out.println("Guerrero " + this.getNombre() + ": ¡Aguantaré hasta el fianl!...");
        }else if(this.getPuntosDeVida() <= 75){
            System.out.println("Guerrero " + this.getNombre() + ": Agh, ¡no podrás conmigo!...");
        }else {
            System.out.println("Guerrero " + this.getNombre() + ": ¿A eso le llamas ataque?...");
        }
        if(this.getPuntosDeVida() > 0) {mostrarSalud();}
        }

    @Override
    protected void gritoDeBatalla() {
        System.out.println("Guerrero "+ this.getNombre()+ ": ¡Por la alianza!");
    }

}
