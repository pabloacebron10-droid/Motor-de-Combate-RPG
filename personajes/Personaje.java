package personajes;

public abstract class Personaje {
    private String nombre;
    private int nivelActual;
    private int puntosDeVida;
    private int ataque;

    private static final int NIVEL_MAX = 10;
    private static final int VIDA_MAX = 100;

    Personaje(String nombre, int nivelActual, int ataque){
        this.nombre = nombre;

        if(nivelActual<0){
            this.nivelActual = 0;
        }else if (nivelActual>NIVEL_MAX){
            this.nivelActual = NIVEL_MAX;
            System.out.println("Nivel máximo alcanzado: Lvl 10.");
        }else {this.nivelActual = nivelActual;}

        this.puntosDeVida = VIDA_MAX;
        this.ataque = ataque;
    }

    abstract protected void recibirDaño(Personaje atacante);
    abstract protected void gritoDeBatalla();

    void setPuntosDeVida(int vida){
        this.puntosDeVida = vida < 0? 0 : vida > VIDA_MAX ? VIDA_MAX : vida;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
    public void setNivelActual(int nivelActual) {
        if(nivelActual<0){
            this.nivelActual = 0;
        }else if (nivelActual>NIVEL_MAX){
            this.nivelActual = NIVEL_MAX;
            System.out.println("Nivel máximo alcanzado: Lvl 10.");
        }else {this.nivelActual = nivelActual;}
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque(){
        return ataque;
    }
    public int getNivelActual() {
        return nivelActual;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    protected void mostrarSalud() {
    System.out.println(this.getClass().getSimpleName() + " " + this.getNombre() +
                       ": " + this.getPuntosDeVida() + "/100 ps");
}
    protected void mensajeDeDaño(Personaje atacante) {
        System.out.println(atacante.getClass().getSimpleName()+ " " + atacante.getNombre() +" ha infligido "+ atacante.getAtaque() + "puntos de daño al "+ this.getClass().getSimpleName()+ " " + this.getNombre());
    }
}
