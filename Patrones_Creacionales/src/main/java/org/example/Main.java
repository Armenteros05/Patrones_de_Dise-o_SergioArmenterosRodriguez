import java.util.ArrayList;
import java.util.List;

// Ejercicio 1: Builder (Ordenador)
class Ordenador {
    private final String cpu;
    private final int ram;
    private final String almacenamiento;
    private final String tarjetaGrafica;
    private final String sistemaOperativo;

    private Ordenador(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
        this.sistemaOperativo = builder.sistemaOperativo;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private String almacenamiento;
        private String tarjetaGrafica;
        private String sistemaOperativo;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder almacenamiento(String almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public Builder tarjetaGrafica(String tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public Builder sistemaOperativo(String sistemaOperativo) {
            this.sistemaOperativo = sistemaOperativo;
            return this;
        }

        public Ordenador build() {
            return new Ordenador(this);
        }
    }

    @Override
    public String toString() {
        return "Ordenador [CPU=" + cpu + ", RAM=" + ram + "GB, Almacenamiento=" + almacenamiento +
                ", Tarjeta Gráfica=" + (tarjetaGrafica != null ? tarjetaGrafica : "Ninguna") +
                ", SO=" + sistemaOperativo + "]";
    }
}

// Ejercicio 2: Singleton (Logger)
class Logger {
    private static Logger instancia;
    private List<String> mensajes;

    private Logger() {
        mensajes = new ArrayList<>();
    }

    public static Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger();
        }
        return instancia;
    }

    public void log(String mensaje) {
        mensajes.add("[LOG] " + mensaje);
        System.out.println("[LOG] " + mensaje);
    }

    public void mostrarLogs() {
        System.out.println("Historial de logs:");
        for (String msg : mensajes) {
            System.out.println(msg);
        }
    }
}

// Ejercicio 3: Strategy (BaseDatos)
interface BaseDatos {
    void guardarUsuario(String nombre);
}

class MySQLDatabase implements BaseDatos {
    @Override
    public void guardarUsuario(String nombre) {
        System.out.println("[MySQL] Usuario guardado: " + nombre);
    }
}

class InMemoryDatabase implements BaseDatos {
    private List<String> usuarios = new ArrayList<>();

    @Override
    public void guardarUsuario(String nombre) {
        usuarios.add(nombre);
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios en memoria:");
        for (String u : usuarios) {
            System.out.println(u);
        }
    }
}

class UsuarioServicio {
    private BaseDatos baseDatos;

    public UsuarioServicio(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void registrarUsuario(String nombre) {
        baseDatos.guardarUsuario(nombre);
    }
}

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1: Builder (Ordenador)
        Ordenador pcGamer = new Ordenador.Builder()
                .cpu("Intel i9")
                .ram(32)
                .almacenamiento("1TB SSD")
                .tarjetaGrafica("RTX 4080")
                .sistemaOperativo("Windows 11")
                .build();

        Ordenador pcOficina = new Ordenador.Builder()
                .cpu("Ryzen 5")
                .ram(16)
                .almacenamiento("512GB SSD")
                .sistemaOperativo("Linux")
                .build();

        System.out.println("PC Gamer: " + pcGamer);
        System.out.println("PC Oficina: " + pcOficina);

        // Ejercicio 2: Singleton (Logger)
        Logger log1 = Logger.getInstancia();
        log1.log("Sistema iniciado");

        Logger log2 = Logger.getInstancia();
        log2.log("Módulo cargado");

        System.out.println("¿Misma instancia?: " + (log1 == log2));
        log1.mostrarLogs();

        // Ejercicio 3: Strategy (BaseDatos)
        // Usamos la estrategia MySQL
        BaseDatos mysql = new MySQLDatabase();
        UsuarioServicio servicioReal = new UsuarioServicio(mysql);
        servicioReal.registrarUsuario("Carlos");  // Guardar en MySQL

        // Usamos la estrategia en memoria
        InMemoryDatabase memoria = new InMemoryDatabase();
        UsuarioServicio servicioPruebas = new UsuarioServicio(memoria);
        servicioPruebas.registrarUsuario("Elena");  // Guardar en memoria
        servicioPruebas.registrarUsuario("Luis");   // Guardar en memoria

        // Mostrar usuarios en memoria
        memoria.mostrarUsuarios();  // Mostrar usuarios guardados en memoria
    }
}
