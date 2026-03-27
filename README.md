🛡 Motor de Combate RPG – Proyecto Integrador

Ciclo Formativo: 1º DAM
Módulo Profesional: Programación
Profesor: Javier Torre Antúnez
Tema: Herencia & Interfaces

📜 Descripción del proyecto

Este proyecto consiste en el desarrollo de la lógica base de un juego de rol (RPG) en Java, centrado en el combate entre personajes de distintas profesiones. La aplicación implementa un motor de combate que permite atacar, curar y gestionar la vida de los personajes, siguiendo las buenas prácticas de herencia, encapsulamiento e interfaces.

El sistema fue diseñado para cumplir los siguientes objetivos:

Representar personajes con características comunes como nombre, nivel actual y puntos de vida.
Garantizar que cada personaje tenga un grito de batalla único.
Implementar habilidades diferenciadas: ataque y curación, según la profesión.
Diseñar un rango de élite (“Paladín”) que combina ataque, curación y defensa automática mediante un escudo.
Simular batallas y mostrar información clara del combate por consola.


🧬 Estructura de clases

El proyecto utiliza herencia e interfaces para organizar la lógica de manera clara y reutilizable.

Clase abstracta Personaje
Contiene los atributos comunes: nombre, nivel actual, puntos de vida y ataque.
Define métodos abstractos obligatorios:
recibirDaño(Personaje atacante)
gritoDeBatalla()
Controla la vida máxima y mínima.
Proporciona métodos de acceso (getNombre, getPuntosDeVida, etc.) para mantener el encapsulamiento.
Interfaces
Atacar: define el método atacar(Personaje objetivo).
AtacarYCurar: extiende la capacidad de atacar y curar.
Bloquear: define la habilidad de defensa especial para paladines.
Profesiones
Guerrero: especialización en combate cuerpo a cuerpo, ataque fijo de 20 puntos, grito de batalla: "¡Por la alianza!"
Mago: ataque variable (10 o 30 puntos según el nivel), grito de batalla: "¡Fuego y destrucción!"
Paladín: rango de élite que puede atacar, curar y bloquear ataques. Grito de batalla: "¡Por el martillo de Uther!"
Clérigo: especialización de paladín, ataca y cura. Grito de batalla: "¡La luz me guía!"
⚔ Motor de combate

El motor de juego permite:

Crear personajes: Guerrero, Mago, Clérigo y Paladín.
Agrupar todos los personajes en un batallón.
Ejecutar los gritos de batalla de todos los personajes al mismo tiempo.
Simular un combate manual:
El Guerrero ataca al Mago.
El Clérigo cura al Mago.
Mostrar mensajes detallados de daño, curación y vida actual en consola.

Ejemplo de mensajes en consola:

Guerrero Thor ha infligido 20 puntos de daño al Mago Merlin
Mago Merlin: ¡El fuego... se apaga!
Salud del Mago Merlin: 80/100 PS

Clérigo Lumen ha curado 20 puntos de salud al Mago Merlin
Salud del Mago Merlin: 100/100 PS
🛠 Tecnologías y conceptos aplicados
Lenguaje: Java 17
Conceptos de programación aplicados:
Herencia
Interfaces
Polimorfismo
Encapsulamiento
Sobrescritura de métodos (@Override)
Buenas prácticas:
Constantes (VIDA_MAX, NIVEL_MAX) para evitar valores mágicos.
Mensajes claros en consola para seguimiento de la batalla.
Validaciones de vida y nivel para garantizar consistencia.


📦 Estructura de paquetes
personajes: contiene las clases de personajes (Personaje, Guerrero, Mago, Paladín, Clérigo)
interfaces: contiene las interfaces (Atacar, AtacarYCurar, Bloquear)
main: contiene el archivo principal de ejecución (JuegoInteractivo.java)


✅ Instrucciones para ejecutar
Compilar todos los archivos .java:
javac src/**/*.java
Ejecutar el juego:
java main.JuegoInteractivo
Seguir las instrucciones en consola para seleccionar los personajes y realizar turnos de ataque o curación.


🎯 Objetivos alcanzados
Implementación de un RPG funcional con turnos de combate.
Uso efectivo de herencia e interfaces para modelar profesiones y habilidades.
Aplicación de encapsulamiento y validación de atributos (vida y nivel).
Simulación de acciones de combate con mensajes claros en consola.