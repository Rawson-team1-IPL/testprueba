package mapear;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import metodospatron.PatronesLinea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class ParseFileToClass {

    private List<String> atributos = new ArrayList<>();
    private String name = "";
    private String pak = "";
    private String id = "";

    public ParseFileToClass(File f) throws IOException {
        String fichero = Leer.LeerDentro(f);
        String[] lineas_sueltas = fichero.split("\n");
        classficarLineas(lineas_sueltas);
    }

    private void classficarLineas(String[] lineas_sueltas) {
        for (String linea : lineas_sueltas) {
            if (PatronesLinea.CrearPatronAtributo(linea)) {
                String atributo = PatronesLinea.BuscarAtributo(linea);
               // System.out.println("OK, linea de atributo encontrada -> " + linea);
                //System.out.println("<property name=" + "\"" + atributo + "\"" + "/>");
                atributos.add(atributo);
            }
            if (PatronesLinea.CrearPatronClase(linea)) {
                name=PatronesLinea.BuscarClase(linea);
                //System.out.println("OK, linea de clase encontrada -> " + linea);
                //System.out.println("<class name=" + "\"" + name + "\"" + ">");

            }
            if (PatronesLinea.CrearPatronpak(linea)) {
                pak=PatronesLinea.Buscarpak(linea);
               // System.out.println("ok,paquete encontrado" + linea);
               // System.out.println("<package name=" + "\"" + pak + "\"" + ">");;

            }

        }
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public String getName() {
        return name;
    }

    public String getPak() {
        return pak;
    }

    public String getId() {
        return name+"_ID";
    }
    
    

}
