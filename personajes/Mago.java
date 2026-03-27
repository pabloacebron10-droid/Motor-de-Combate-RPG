package personajes;

import interfaces.Atacar;

public class Mago extends Personaje implements Atacar {
    
    public Mago(String nombre, int nivelActual){
        super(nombre, nivelActual, nivelActual > 5 ? 30 : 10 );
    }

    @Override
    public void atacar(Personaje objetivo) {
        this.gritoDeBatalla();
        objetivo.recibirDaño(this);

        this.setNivelActual(this.getNivelActual() + 1);
        this.actualizarAtaque();

        if(this.getNivelActual()<10){
            System.out.println("Habilidad rank-up del mago subió su nivel.\nNivel actual: "+ this.getNivelActual());
        }else { 
            System.out.println("Mago al nivel máximo: Lvl 10");}
    }

    @Override
    protected void recibirDaño(Personaje atacante) {
        int daño = atacante.getAtaque();
        this.setPuntosDeVida(this.getPuntosDeVida() - daño);

        mensajeDeDaño(atacante);

        if(this.getPuntosDeVida()<=0){
            System.out.println("Mago " + this.getNombre() + ": El fuego... se apaga...\nEl mago "+ this.getNombre() + " ha sido debilitado...  0/100 ps");
        }else if(this.getPuntosDeVida() <= 25){
            System.out.println("Mago " + this.getNombre() + ": ¡No podráss con mi llama!...");
        }else if(this.getPuntosDeVida() <= 75){
            System.out.println("Mago " + this.getNombre() + ":  ¡el fuego me protegerá!...");
        }else {
            System.out.println("Mago " + this.getNombre() + ": ¡Ja! Tu ataque es debil ante el poder de mi llamarada...");
        }
        
        if(this.getPuntosDeVida() > 0) {mostrarSalud();}
    }

    @Override
    protected void gritoDeBatalla() {
        System.out.println("Mago "+ this.getNombre()+ ": ¡Fuego y destrucción!");
    }

    public void actualizarAtaque() {
        setAtaque(this.getNivelActual() > 5 ? 30 : 10);
    }
}

