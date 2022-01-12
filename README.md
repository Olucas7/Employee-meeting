
# Employee Meeting

Ejercicio practico de programación orientada a objetos.



## Instrucciones

El proyecto se desarrollo en java version 8 y maven. Junit 4 es la unica
dependencia que se debe descargar.

* Punto de arranque del programa esta en la clase llamada Main.
* El proyecto cuenta ya con dos archivos de prueba y va a correr uno por defecto.

## Solución

Aprovechando la naturaleza del lenguaje de programación utilizado, 
esta solución se basa en el paradigma orientado a objetos. Gracias al
patrón arquitectónico en capas se pudo organizar, delegar un papel y una responsabilidad
especifica a cada capa. 

El enfoque de la solución fue resolver un caso particular el cual es saber si dos personas se encontraron en un dia en específico, resolviendo esto se pudo escalar y usar esto para poder saber cuantos empleados se encuentran durante una semana de trabajo. Trabajando en esta idea se descubrió una teoría "Sea un dia cualquiera y dos empleados con horas de entrada y salida definidos, Si la diferencia entre la hora de entrada del empleado segundo en llegar(valor mayor) y la hora de entrada del empleado que llego primero(valor menor) es menor que el total de horas trabajadas por el empleado primero en llegar, entonces ambos trabajadores se encuentran.", es importante acotar que para este programa si un empleado se va y otro llega a la misma hora no se los toma en cuenta.

Por ultimo, la metodologia utilizada en el proceso del desarrollo fue desarrollo guiado por tests(TDD).
## Diagrama UML



<img width="808" alt="uml-diagrama" src="https://user-images.githubusercontent.com/55326984/149168254-ea6cf1cd-15da-48b5-b491-5d30567788fb.png">
