# BlackJack de Javier Jiménez-Alfaro Hacha

## Funcionalidades

- La aplicación nos navegará entre Screens al iniciar y al completar una partida.
- Para iniciar una partida, se hará desde la pantalla de victoria, que sólo se muestra al completar una partida. Si salimos al menú principal y volvemos, nuestro progreso se salvará.
- Los botones se deshabilitarán cuando la partida se complete y hasta que no se inicie una nueva. A su vez, el botón que nos llevará a la pantalla de victoria sólo se mostrará cuando la partida esté finalizada.
- Si la baraja se completa, no se robarán más cartas.
- Si el jugador tiene más cartas que las que se pueden mostrar en pantalla, su baraja se podrá deslizar para mostrar todas, tanto en la partida como en la pantalla de victoria.
- Existe un modo para jugar contra otro jugador, y un modo para jugar contra la IA.
  
## Criterios de Evaluación
### Utiliza clases de ViewModel para gestionar la lógica de las Vistas.
En mi caso, he utilizado una clase ViewModel para las dos screens que procesan información (La del PvP y la de Victoria), ya que los datos son los mismos, pero sí, tengo una clase ViewModel exclusivamente con lógica y las Screens con únicamente Composables(Elementos visuales)
### Crea en las clases ViewModel variables privadas (MutableLiveData) y públicas (LiveData), junto con variables observables de la variable pública del ViewModel en la Vista (Screen).
No superado.
### Cada pantalla se escribe en un fichero "Screen" diferente.
Superado. Las Screens son ModoJugadorVSJugador, PantallaVictoria y MainMenu. Estas están con el ViewModel en el Package _screens_
### Organiza las Vistas con distintas funciones Composable que componen la pantalla visual completa.
En mis clases, las visuales son generalmente divididas en varias funciones Composable, que luego son llamadas en una columna principal la cual recoge a todas.
### Utiliza la función composable NavHost para la navegación entre pantallas (screens diferentes).
Superado.
### Existe limpieza y organización del código.
Espero que superado.
### Incluye comentarios internos explicativos.
Superado.
### Calidad del código y funcionalidad correcta.
Espero que superado.
### Las clases y funciones están documentadas (KDoc).
Superado.
### Las clases de datos las inicializa en un sitio correcto, dónde solo se van a llamar una vez, evitando así los problemas de nulidad en el código.
Creo que superado.
### Manejo correcto de errores y excepciones, evitando "casques" en la aplicación.
Superado. La aplicación no tiene posibilidad a errores, ya que sólo funciona mediante botones y he probado todos los casos. No he controlado excepciones porque no lo he sentido necesario.
### En las Vistas solo existen componentes gráficos, llamadas a variables observables o funciones del ViewModel, evitando incluir lógica en ellas.
Superado.

## Ramas
Mi proyecto tiene 5 ramas.

### main
Donde he realizado la mayor parte del progreso y de los commits. Es la rama más avanzada del proyecto.

### MutableDataTest
Un intento fallido de convertir todas mis variables en LiveData y MutableLiveData<>

### ViewModel
La rama que utilicé para hacer el paso al modelo ViewModel

### testDiego
Una rama que creaste tú para enseñarme una cosa en clase. La utilicé un tiempo para terminar de aplicar lo aprendido y volví a _main_

### origin/feedback
La autogenerada por GitHub, no la he utilizado.



---
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/2k2-pIk4)
# Práctica 3 - Black Jack

## Desarrollo de un Juego de Blackjack con Modos de Juego y Clases Adicionales

### Objetivo:

El objetivo de esta práctica es aplicar los conceptos de Jetpack Compose, Kotlin y programación orientada a objetos para desarrollar un juego de Blackjack en Android Studio. En esta versión, se introducirán dos modos de juego (2 jugadores y 1 jugador contra la máquina) y se implementarán clases adicionales para gestionar la baraja, las cartas y los jugadores.

### Requisitos Básicos:
1. Interfaz Gráfica:

   ```
   Diseñar la interfaz del juego utilizando Jetpack Compose, considerando la opción de seleccionar el modo de juego al inicio.
   Mostrar las cartas de los jugadores y del crupier de manera clara y atractiva (imágenes).
   ```

2. Lógica del Juego:

   ```
   Implementar la lógica del juego de Blackjack para ambos modos de juego.
   Esto incluye la distribución inicial de cartas, el cálculo de la puntuación de la mano y las decisiones del jugador (pedir carta, plantarse, etc.).
   ```

3. Manejo de Estado:

   ```
   Utilizar ViewModels para gestionar el estado del juego de manera eficiente.
   Actualizar la interfaz de usuario de acuerdo con el estado actual del juego.
   ```

4. Clases Enumeradas:

   ```
   Crear dos clases enumeradas: una para definir los palos de la baraja y otra para los nombres de las cartas de cada palo.
   ```
   
5. Clase Baraja:

   ```
   Crear una clase Baraja con un companion object que contenga:
   - Una lista de objetos Carta que representan las cartas de la baraja.
   - Métodos para crear una nueva baraja y barajar o desordenar las cartas.
   ```
  
6. Modos de Juego:

   ```
   Implementar dos modos de juego:
   - Modo 1 Jugador contra la Máquina: El jugador juega contra la máquina (crupier).
   - Modo 2 Jugadores: Dos jugadores compiten entre sí.

### Clases Adicionales:

1. Clase Carta:

   ```
   Crear una clase Carta que represente una carta de la baraja con propiedades como palo, nombre, valor...
   ```

2. Clase Jugador:

   ```
   Crear una clase Jugador que tenga propiedades como nombre, mano (conjunto de cartas), fichas (en el caso del modo 2 Jugadores), etc.
   ```
   
### Recursos:

   * Documentación oficial de Jetpack Compose: [Compose Overview](https://developer.android.com/jetpack/compose?hl=es-419)
   * Documentación oficial de Kotlin: [Kotlin Docs](https://kotlinlang.org/docs/home.html)
   * Recuerda fomentar la modularidad y la reutilización del código mediante la implementación de clases y objetos bien estructurados.
