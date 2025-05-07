Resolución de Ejercicios - Patrones Creacionales
Ejercicio 1 - Builder: Construcción de Ordenadores
Explicación:
Este ejercicio aplica el patrón Builder para construir objetos complejos (Ordenador) de manera flexible y legible. La clase Ordenador es inmutable, y su construcción se realiza mediante una clase interna Builder que permite configurar cada campo paso a paso antes de llamar a 'build()'.
Ejercicio 2 - Singleton: Registro Centralizado de Logs
Explicación:
Este ejercicio trata sobre el patrón Singleton para asegurar que solo exista una única instancia del registrador (Logger) en toda la ejecución del programa. Esta clase ofrece un método para registrar mensajes y otro para mostrarlos todos juntos. De este modo, centraliza la trazabilidad de eventos.
Ejercicio 3 - Inyección de Dependencias: Gestión de Usuarios
Explicación:
El objetivo de esta práctica es aplicar el principio de inyección de dependencias para que la clase de servicio que maneja usuarios no dependa directamente de la base de datos. En su lugar, recibe una interfaz como parámetro, permitiendo cambiar la implementación fácilmente (real o simulada).
