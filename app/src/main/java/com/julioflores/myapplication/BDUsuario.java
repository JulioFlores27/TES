package com.julioflores.myapplication;

public class BDUsuario {
    String nombre_padre, nombre_estudiante, apellidos, correo, contraseña, numero_telefónico, nombre_escuela;

    public BDUsuario(String nombre_padre, String nombre_estudiante, String apellidos, String correo, String contraseña, String numero_telefónico, String nombre_escuela){
        this.nombre_padre = nombre_padre;
        this.apellidos = apellidos;
        this.numero_telefónico = numero_telefónico;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre_escuela = nombre_escuela;
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getNombre_padre() { return nombre_padre; }

    public void setNombre_padre(String nombre_padre) { this.nombre_padre = nombre_padre; }

    public String getNombre_estudiante() { return nombre_estudiante; }

    public void setNombre_estudiante(String nombre_estudiante) { this.nombre_estudiante = nombre_estudiante; }

    public String getApellidos() { return apellidos; }

    public void getApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }

    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public String getNumero_telefónico() { return numero_telefónico; }

    public void setNumero_telefónico(String numero_telefónico) { this.numero_telefónico = numero_telefónico; }

    public String getNombre_escuela() { return nombre_escuela; }

    public void setNombre_escuela(String nombre_escuela) { this.nombre_escuela = nombre_escuela; }

    @Override
    public String toString() {
        return nombre_padre + apellidos + numero_telefónico + correo +
                contraseña + nombre_escuela + nombre_estudiante;
    }
}