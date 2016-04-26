package archivosBinarios;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Profesor> lista = new ArrayList();

        lista.add(new Profesor("03514785J", "Jose", "Informatica", 15));
        lista.add(new Profesor("03514785J", "Jose", "Informatica", 68));
        lista.add(new Profesor("03514785J", "Jose", "Informatica", 15));
        lista.add(new Profesor("03514785J", "Jose", "Administracion", 35));
        lista.add(new Profesor("03514785J", "Jose", "Administracion", 40));
        lista.add(new Profesor("03514785J", "Jose", "Administracion", 20));
        lista.add(new Profesor("03514785J", "Jose", "Turismo", 36));
        lista.add(new Profesor("03514785J", "Jose", "Turismo", 15));

        Path archivo = Paths.get("Datos.dat");
        ArchivoProfesores ap = new ArchivoProfesores(archivo);

        System.out.println(ap.guardarProfesores(lista));
        System.out.println(ap.mostrarProfesores("Informatica"));
        System.out.println(ap.clasificarProfesores(30));

    }

}
