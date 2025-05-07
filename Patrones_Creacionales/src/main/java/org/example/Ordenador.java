package org.example;

public class Ordenador {
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
