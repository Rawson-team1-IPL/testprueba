/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodospatron;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import mapear.Leer;
import static mapear.Leer.LeerD;
import mapear.ParseFileToClass;

/**
 *
 * @author Usuario
 */
public class principal {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce directorio del proyecto:");
        String directorio = sc.nextLine();
        ArrayList<String> fichero = LeerD(directorio + "\\src");

        for (String string : fichero) {

            File f = new File(string);
            String nombrearchiv = f.getAbsolutePath() + f.getName();
            String sinpunto = nombrearchiv.replaceAll(".java", "");

            ParseFileToClass classParser = new ParseFileToClass(f);
            EscribirDom generador = new EscribirDom(classParser);
            generador.GenerarDocumento();
           System.out.println("Se crea xml del archivo: "+nombrearchiv);
            generador.GenerarXml(sinpunto);
        }
    }
}
