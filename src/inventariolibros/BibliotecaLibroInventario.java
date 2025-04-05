/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventariolibros;

import static inventariolibros.InventarioLibros.inventario;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roroc
 */
public class BibliotecaLibroInventario {
    public static File register;
    public static HashMap<Libro, String> registroLibros = new HashMap<>();
    
    /*
 * Crea un fichero llamado "registroBiblioteca.txt" en el directorio del proyecto si no existe.
    */
    public static void crearFichero() {
        String proyectDirection = System.getProperty("user.dir");
        String separator = File.separator;
        String fileDirection = proyectDirection + separator + "registroBiblioteca.txt";
        register = new File(fileDirection);
        try {
            if(!register.exists()){
                register.createNewFile(); 
            }
        } catch (IOException ex) {
            System.err.println("Error generico");
        }
    }
/**
 * Obtiene un libro por su ISBN desde el inventario.
 */
    
    public static Libro devolverLibro(String isbn) {
        Libro libro = null;
        if (inventario.containsKey(isbn)) {
            libro = inventario.get(isbn);
        }
        return libro;
    }
    /**
 * Obtiene la representación en cadena de un libro.
 */
    public static String devolverLibroToString(Libro libro_temporal) {
        String libroString = null;
        if (registroLibros.containsKey(libro_temporal)) {
            libroString = registroLibros.get(libro_temporal);
        }
        return libroString;
    }
/**
 * Añade un nuevo libro al inventario y al registro.
 */
    public static void addLibro(String titulo, String autor, String ISBN, double precio, int cantidadInventario, boolean existe) {
        if (!existe) {
            Libro libro_temporal = new Libro(titulo, autor, ISBN, precio, cantidadInventario);
            inventario.put(ISBN, libro_temporal);
            registroLibros.put(libro_temporal, libro_temporal.toString());
            String libroToString = devolverLibroToString(libro_temporal);
            actualizarLibroRegistro();
        }
        //Seguir acá, con el registro string 
        
        
    }
/**
 * Actualiza el archivo de registro con los libros almacenados.
 */
    public static void actualizarLibroRegistro(){
        try {
            FileWriter fw = new FileWriter(register);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String next : registroLibros.values()) {
                bw.write(next);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.err.println("Error genérico ");
        }
        
        
    }
    /**
 * Edita los detalles de un libro en el inventario.
 */
    public static boolean editarLibro(String titulo, String autor, double precio, int cantidadInventario, String ISBN) {

        Libro libroActualizar = devolverLibro(ISBN);
        if (libroActualizar != null) {
            libroActualizar.setTitulo(titulo);
            libroActualizar.setAutor(autor);
            libroActualizar.setCantidadInventario(cantidadInventario);
            libroActualizar.setPrecio(precio);
            actualizarLibroRegistro();
            return true;
        } else {
            return false;
        }
    }

    /**
 * Verifica si un libro existe en el inventario.
 */
    public static boolean existenciaLibro(String isbn) {
        Libro libro_temporal = devolverLibro(isbn);
        if (libro_temporal != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
 * Verifica si un libro existe en el inventario usando el metodo anterior para usar su return.
 */
    public static boolean existenciaLibroDevolver(String isbn) {
        boolean existe = existenciaLibro(isbn);
        Libro libro_temporal = devolverLibro(isbn);
        if (existe) {
            return true;
        } else {
            return false;
        }
    }
/**
 * Elimina un libro del inventario y del registro.
 */
    public static void eliminarLibro(Libro libro_temporal) {
        inventario.remove(libro_temporal.getISBN());
        registroLibros.remove(libro_temporal);
        actualizarLibroRegistro();
    }

    public static boolean existeLibro(String ISBN) {
        boolean existe = false;
        Iterator it = inventario.keySet().iterator();
        boolean hash = it.hasNext();
//        if (!hash) {
//            System.out.println("Libro no existe, se puede añadir, acá");
//        }
        while (it.hasNext()) {
            String key = (String) it.next();
            if (inventario.get(key).getISBN().equalsIgnoreCase(ISBN)) {
                existe = true;
                break;
            }
        }
        return existe;

    }
    
    /**
 * Lee el contenido del archivo de inventario.
 */
    public static ArrayList<String> leeInventario() {
        ArrayList<String> libroString = new ArrayList<>();
        try {
            FileReader fr = new FileReader(register);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                libroString.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error generico");
        } catch (IOException ex) {
            System.err.println("Error generico");
        }
        return libroString;
    }
/**
 * Inicializa el registro de libros desde un archivo.
 */
       public static void initRegisterLibro(ArrayList<String> registerLibro) {
            for (String librostring : registerLibro) {
               String[] parts = librostring.split(",");
            Libro libro_temporal = new Libro(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
            inventario.put(parts[2], libro_temporal);
            registroLibros.put(libro_temporal, librostring);
            actualizarLibroRegistro();
           }

    }
}
