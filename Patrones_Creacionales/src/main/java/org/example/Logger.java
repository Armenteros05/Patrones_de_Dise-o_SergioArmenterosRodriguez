package org.example;

import java.util.ArrayList;
import java.util.List;

public class Logger {
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
