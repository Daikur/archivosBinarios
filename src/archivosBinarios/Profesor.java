package archivosBinarios;

import java.io.Serializable;

public class Profesor implements Serializable{
    private String nombre, nif;
    private String depart;
    private int edad;

    public Profesor(String nif, String nombre, String depart, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.depart = depart;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Nombre: "+this.nombre+"\tcon DNI: "+this.nif+"\tdepartamento: "+this.depart+"\tcon Edad: "+this.edad+"\n"; 
    }
    
    
}
