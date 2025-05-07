package org.example;

import java.util.ArrayList;
import java.util.List;

// Interfaz BaseDatos
interface BaseDatos {
    void guardarUsuario(String nombre);
}

// Implementación MySQLDatabase de BaseDatos
class MySQLDatabase implements BaseDatos {
    @Override
    public void guardarUsuario(String nombre) {
        System.out.println("[MySQL] Usuario guardado: " + nombre);
    }
}

// Implementación InMemoryDatabase de BaseDatos
class InMemoryDatabase implements BaseDatos {
    private List<String> usuarios = new ArrayList<>();

    @Override
    public void guardarUsuario(String nombre) {
        usuarios.add(nombre);
    }

    // Método para mostrar los usuarios guardados en memoria
    public void mostrarUsuarios() {
        System.out.println("Usuarios en memoria:");
        for (String u : usuarios) {
            System.out.println(u);
        }
    }
}

// Clase UsuarioServicio que usa la estrategia (BaseDatos)
class UsuarioServicio {
    private BaseDatos baseDatos;

    public UsuarioServicio(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void registrarUsuario(String nombre) {
        baseDatos.guardarUsuario(nombre);
    }
}
