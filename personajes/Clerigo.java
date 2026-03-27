package personajes;

public class Clerigo extends Paladin {
    
    public Clerigo(String nombre, int nivelActual) {
        super(nombre, nivelActual, 10, 20 );
    }

     @Override
    public void atacar(Personaje objetivo) {
        this.gritoDeBatalla();
        objetivo.recibirDaño(this);
    }

    @Override
    public void curar(Personaje objetivo) {
        System.out.println("¡Que la luz te cure!");
        int vidaAntes = objetivo.getPuntosDeVida();
        objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() + this.getCuracion());
        int curacionReal = objetivo.getPuntosDeVida() - vidaAntes;
        System.out.println("El Clérigo "+ this.getNombre() +" ha curado "+ curacionReal + " puntos de salud al "+ objetivo.getClass().getSimpleName()+ " " + objetivo.getNombre());
        System.out.println("Salud del "+ objetivo.getClass().getSimpleName()+ " " + objetivo.getNombre()+ ": "+ objetivo.getPuntosDeVida()+ "/100 Ps" );
    }

    @Override
    protected void recibirDaño(Personaje atacante) {

        if(super.bloquear()){
            System.out.println("¡Habilidad del Paladin activada!\nEl paladín levanta su escudo sagrado y bloquea el ataque");
        }else{
            mensajeDeDaño(atacante);

            int daño = atacante.getAtaque();
            this.setPuntosDeVida(this.getPuntosDeVida() - daño);

            if(this.getPuntosDeVida()<=0){
                System.out.println("Clérigo " + this.getNombre() + ": La luz... se apaga...\nEl Clérigo "+ this.getNombre() + " ha sido debilitado...  0/100 ps");
            }else if(this.getPuntosDeVida()>0 && this.getPuntosDeVida() <= 25){
                System.out.println("Clérigo " + this.getNombre() + ": Dolor, sufrimiento...");
            }else if(this.getPuntosDeVida()>25 && this.getPuntosDeVida() <= 75){
                System.out.println("Clérigo " + this.getNombre() + ":  La luz me protegerá...");
            }else {
                System.out.println("Clérigo " + this.getNombre() + ": La luz me dará la victoria...");
            }
            if(this.getPuntosDeVida() > 0) {mostrarSalud();}
        }
    } 
    

    @Override
    protected void gritoDeBatalla() {
        System.out.println("¡La luz me guía!");
    }

}
