/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodospatron;

/**
 *
 * @author Usuario
 */
public class PatronesLinea {
    public static String BuscarAtributo(String att) {
//        int index = att.indexOf(" ", att.indexOf("p"));
//        System.out.println("index era = " + index);
        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");
        String sinpunto = tokens[2].replaceAll(";", "");
        return sinpunto;
    }
     public static boolean CrearPatronAtributo(String lineFromJavaFile)
    {
        String patronDeAtributo = "[ \t]*(public|private)[ \t]+(.)+[ \t]+(.)+;";
        return lineFromJavaFile.matches(patronDeAtributo);
    }
       public static String BuscarClase(String att) {
//        int index = att.indexOf(" ", att.indexOf("p"));
//        System.out.println("index era = " + index);
        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");
        return tokens[2];
    }
       public static boolean CrearPatronClase(String lineFromJavaFile)
    {
        String patronDeClase = "[ \t]*public[ \t]+class[ \t]+(.)+";
        return lineFromJavaFile.matches(patronDeClase);
    }
        public static String Buscarpak(String att) {
//        int index = att.indexOf(" ", att.indexOf("p"));
//        System.out.println("index era = " + index);
        String attLimpio = att.trim();
        while (attLimpio.contains("  ")) {
            attLimpio = attLimpio.replaceAll("  ", " ");
        }
        String[] tokens = attLimpio.split(" ");
        String eliminapunto=tokens[1].replaceAll(";", " ");
      String sinpunto = tokens[1].replaceAll(";", "");
        return sinpunto;
    }
           public static boolean CrearPatronpak(String lineFromJavaFile)
    {
        String patrondepak = "[ \t]*package+[ \t]+(.)+;";
        return lineFromJavaFile.matches(patrondepak);
    }
     
}
