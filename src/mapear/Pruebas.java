package mapear;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
/**
 *
 * @author PC019
 */
public class Pruebas {

    public static String Buscarpak(String att) {

        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");
        String sinpunto = tokens[1].replaceAll(";", "");
        return sinpunto;
    }

    public static boolean CrearPatronpak(String lineFromJavaFile) {
        String patrondepak = "[ \t]*package+[ \t]+(.)+;";
        return lineFromJavaFile.matches(patrondepak);
    }

    public static String BuscarAtributo(String att) {
       
        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");
        String sinpunto = tokens[2].replaceAll(";", "");
        return sinpunto;

    }

    public static String BuscarClase(String att) {
   
        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");

        return tokens[2];

    }

    public static boolean isAttLineInJavaFile(String lineFromJavaFile) {
        String patronDeAtributo = "[ \t]*(public|private)[ \t]+(.)+[ \t]+(.)+;";
        return lineFromJavaFile.matches(patronDeAtributo);
    }

    public static boolean CrearPatronClase(String lineFromJavaFile) {
        String patronDeClase = "[ \t]*public[ \t]+class[ \t]+(.)+";
        return lineFromJavaFile.matches(patronDeClase);
    }

    public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        File f= new File("C:\\Users\\Usuario\\Desktop\\NetBeansProjects\\CrearXml\\src\\convertirxml\\Localidad.java");
        Leer a = new Leer();

        String fichero = a.LeerDentro(f);
        String[] lineas_sueltas = fichero.split("\n");
        for (String linea : lineas_sueltas) {
            if (isAttLineInJavaFile(linea)) {
                System.out.println("OK, linea de atributo encontrada -> " + linea);
                System.out.println("<property name=" + "\"" + BuscarAtributo(linea) + "\"" + "/>");
            }
            if (CrearPatronClase(linea)) {
                System.out.println("OK, linea de clase encontrada -> " + linea);
                System.out.println("<class name=" + "\"" + BuscarClase(linea) + "\"" + ">");

            }
            if (CrearPatronpak(linea)) {

                System.out.println("ok,paquete encontrado" + linea);
                System.out.println("<package name=" + "\"" + Buscarpak(linea) + "\"" + ">");;

            }

        }
        System.out.println("feliz = \n" + fichero);

        // System.out.println(">" + getStrAtributo("private HashMap<Integer,String> nombre;"));
//    for(String string : b)
//        {
//            a.LeerDentro(string); 
//        }
    }

}
