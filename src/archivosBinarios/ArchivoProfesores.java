package archivosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArchivoProfesores {

    Path archivo;

    public ArchivoProfesores(Path archivo) {
        if (archivo != null) {
            this.archivo = archivo;
        } else {
            throw new RuntimeException("El archivo no es valido");
        }
    }

    public void setArchivo(Path archivo) {
        this.archivo = archivo;
    }

    public boolean guardarProfesores(List<Profesor> lista) {
        boolean resultado = false;
//        File f = new File("Datos.dat");
        try (FileOutputStream fileOutput = new FileOutputStream(archivo.toFile(), false);
                ObjectOutputStream datos = new ObjectOutputStream(fileOutput)) {
            for (Profesor listProfesores : lista) {
                datos.writeObject(listProfesores);
            }
            resultado = true;
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero" + ex.getMessage());
        }
        return resultado;
    }

    public List<Profesor> mostrarProfesores(String departamento) {
        List<Profesor> listaP = new ArrayList();
        Profesor p;
//        File f = new File("Datos.dat");
        try (FileInputStream fileInput = new FileInputStream(archivo.toFile());
                ObjectInputStream file = new ObjectInputStream(fileInput)) {
            while (true) {
                p = (Profesor) file.readObject();
                if (p.getDepart().equalsIgnoreCase(departamento)) {
                    listaP.add(p);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("La clase no existe");
        } catch (IOException ex) {
//            System.out.println("Error al abrir el fichero" + ex.getMessage());
        }
        return listaP;
    }

    public List<Profesor> clasificarProfesores(int edad) {
        List<Profesor> listaSabios = new ArrayList();
//        File f = new File("Datos.dat");
        Profesor p;
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(archivo.toFile()));
                ObjectOutputStream salida = new ObjectOutputStream(
                        new FileOutputStream("ProfesoresSabios.dat"))) {
            while (true) {
                p = (Profesor) entrada.readObject();
                if (p.getEdad() > edad) {
                    listaSabios.add(p);
                    salida.writeObject(p);
                }
            }
        } catch (ClassNotFoundException ex) {
//            System.out.println("La clase no existe");
        } catch (IOException ex) {
//            System.out.println("Error al abrir el fichero" + ex.getMessage());
        }

//        File fsabio = new File("ProfesoresSabios.dat");
//        try (FileOutputStream fileOutput = new FileOutputStream(fsabio);
//                ObjectOutputStream file = new ObjectOutputStream(fileOutput)) {
//            for (Profesor ps : listaSabios) {
//                file.writeObject(ps);
//                resultado = true;
//            }
//        } catch (IOException ex) {
//            System.out.println("Error al abrir el fichero" + ex.getMessage());
//        }
        return listaSabios;
    }
}
