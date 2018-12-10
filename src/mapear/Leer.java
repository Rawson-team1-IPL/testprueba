package mapear;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class Leer {

    public static ArrayList<String> LeerD(String directorio)  {
        ArrayList<String> fiche = new ArrayList();
        File f = new File(directorio);
        File[] ficheros = f.listFiles();
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isDirectory()) {
                //getpath saca la ruta del fichero
                fiche.addAll(LeerD(ficheros[i].getPath()));
               System.out.println(ficheros[i].getName());

                LeerD(ficheros[i].getPath());
            } else {
                fiche.add(ficheros[i].getPath());
              // System.out.println(ficheros[i].getName());
             
            }
        }
        return fiche;
    }

    public static String LeerDentro(File f) throws IOException {
        FileReader nuevo = new FileReader(f);
        BufferedReader mibuffer = new BufferedReader(nuevo);
        String linea = "";
        String v = "";
        do {
            v += linea + "\n";
            linea = mibuffer.readLine();
        } while (linea != null);

        return v.substring(1);

    }

}
