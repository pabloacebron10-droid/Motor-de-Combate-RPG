package personajes;

import interfaces.AtacarYCurar;
import interfaces.Bloquear;

public class Paladin extends Personaje implements AtacarYCurar, Bloquear {

    private int curacion;

    public Paladin(String nombre, int nivelActual, int ataque, int curacion) {
        super(nombre, nivelActual, ataque);
        this.curacion = curacion;
    }

    public Paladin(String nombre, int nivelActual){
        this(nombre, nivelActual, 15, 15);
    }

    @Override
    public void atacar(Personaje objetivo) {
        this.gritoDeBatalla();
        objetivo.recibirDaño(this);
    }


    @Override
    public void curar(Personaje objetivo) {
        System.out.println("¡Que mi poder sane tus heridas!");
        int vidaAntes = objetivo.getPuntosDeVida();
        objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() + this.curacion);
        int curacionReal = objetivo.getPuntosDeVida() - vidaAntes;
        System.out.println("El Paladin "+ this.getNombre() +" ha curado "+ curacionReal + " puntos de salud al "+ objetivo.getClass().getSimpleName()+ " " + objetivo.getNombre());
        System.out.println("Salud del "+ objetivo.getClass().getSimpleName()+ " " + objetivo.getNombre()+ ": "+ objetivo.getPuntosDeVida()+ "/100 Ps" );
    }

    @Override
    public boolean bloquear() {
        return Math.random() < 0.5;
    }

    @Override
    protected void recibirDaño(Personaje atacante) {

        if(bloquear()){
            System.out.println("¡Habilidad del Paladin activada!\nEl paladín levanta su escudo sagrado y bloquea el ataque");
        }else{
            int daño = atacante.getAtaque();
            this.setPuntosDeVida(this.getPuntosDeVida() - daño);

            mensajeDeDaño(atacante);

            if(this.getPuntosDeVida()<=0){
                System.out.println("Paladín " + this.getNombre() + ": Uther, nos vemos al otro lado...\nEl Paladin "+ this.getNombre() + " ha sido debilitado...  0/100 ps");
            }else if(this.getPuntosDeVida() <= 25){
                System.out.println("Paladín " + this.getNombre() + ": Agh, por el martillo maldito...");
            }else if(this.getPuntosDeVida() <= 75){
                System.out.println("Paladín " + this.getNombre() + ":  ¡La fuerza de mi escudo aguantará!...");
            }else {
                System.out.println("Paladín " + this.getNombre() + ": ¡Jamás podras contra la Espada de Azeroth!...");
            }
            if(this.getPuntosDeVida() > 0) {mostrarSalud();}
        }
    } 
    

    @Override
    protected void gritoDeBatalla() {
        System.out.println("¡Por el martillo de Uther!");
    }

    public int getCuracion() {
        return curacion;
    }

}
