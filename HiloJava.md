# ¿Que es un hilo en java?
La Máquina Virtual Java (JVM) es un sistema multihilo. Es decir, es capaz de ejecutar varios
hilos de ejecución simultáneamente. La JVM gestiona todos los detalles, asignación de tiempos
de ejecución, prioridades, etc., de forma similar a como gestiona un Sistema Operativo
múltiples procesos. La diferencia básica entre un proceso de Sistema Operativo y un Thread
Java es que los hilos corren dentro de la JVM, que es un proceso del Sistema Operativo y por
tanto comparten todos los recursos, incluida la memoria y las variables y objetos allí definidos.
A este tipo de procesos donde se comparte los recursos se les llama a veces procesos ligeros
(lightweight process).
Java da soporte al concepto de Thread desde el propio lenguaje, con algunas clases e
interfaces definidas en el paquete java.lang y con métodos específicos para la manipulación
de Threads en la clase Object.
Desde el punto de vista de las aplicaciones los hilos son útiles porque permiten que el flujo del
programa sea divido en dos o más partes, cada una ocupándose de alguna tarea de forma
independiente. Por ejemplo un hilo puede encargarse de la comunicación con el usuario,
mientras que otros actúan en segundo plano, realizando la transmisión de un fichero,
accediendo a recursos del sistema (cargar sonidos, leer ficheros ...), etc. De hecho, todos los
programas con interface gráfico (AWT o Swing) son multihilo porque los eventos y las rutinas de
dibujado de las ventanas corren en un hilo distinto al principal. 

# ¿Como se implementa?
-Clase Thread-
La forma más directa para hacer un programa multihilo es extender la clase Thread, y redefinir
el método run(). Este método es invocado cuando se inicia el hilo (mediante una llamada al
método start() de la clase Thread). El hilo se inicia con la llamada al método run() y
termina cuando termina éste.

public class ThreadEjemplo extends Thread {

public ThreadEjemplo(String str) {

super(str);

 }
 
public void run() {

 for (int i = 0; i < 10 ; i++)
 
 System.out.println(i + " " + getName());
 
 System.out.println("Termina thread " + getName());
 
 }
 
public static void main (String [] args) {

 new ThreadEjemplo("Pepe").start();
 
 new ThreadEjemplo("Juan").start();
 
 System.out.println("Termina thread main");
 
 }
 
}

-Interfaz Runnable-
La interface Runnable proporciona un método alternativo a la utilización de la clase Thread,
para los casos en los que no es posible hacer que la clase definida extienda la clase Thread.
Esto ocurre cuando dicha clase, que se desea ejecutar en un hilo independiente deba extender
alguna otra clase. Dado que no existe herencia múltiple, la citada clase no puede extender a la
vez la clase Thread y otra más. En este caso, la clase debe implantar la interface Runnable,
variando ligeramente la forma en que se crean e inician los nuevos hilos.
El siguiente ejemplo es equivalente al del apartado anterior, pero utilizando la interface
Runnable: 

public class ThreadEjemplo implements Runnable {

public void run() {

 for (int i = 0; i < 5 ; i++)
 
 System.out.println(i + " " +
 
 Thread.currentThread().getName());
 
 System.out.println("Termina thread " +
 
 Thread.currentThread().getName());
 
 }
 
public static void main (String [] args) {

 new Thread (new ThreadEjemplo(), "Pepe").start();
 
 new Thread (new ThreadEjemplo(), "Juan").start();
 
 System.out.println("Termina thread main");
 
 }
 
}
