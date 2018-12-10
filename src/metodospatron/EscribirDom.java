/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodospatron;




import mapear.ParseFileToClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Usuario
 */
public class EscribirDom {
    private Document document;
    private ParseFileToClass classFile;
    
    public EscribirDom(ParseFileToClass classFile) throws ParserConfigurationException {
       this.classFile = classFile;
       DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
       DocumentBuilder builder=factoria.newDocumentBuilder();
       document = builder.newDocument();
       
    }
    public void GenerarDocumento(){
      Element root = document.createElement("hibernate-mapping");
      root.setAttribute("package", classFile.getPak());
      document.appendChild(root);
      Element clase= document.createElement("class");
      clase.setAttribute("name", classFile.getName());
      root.appendChild(clase);
      Element id= document.createElement("id");
      id.setAttribute("col",classFile.getId());
      clase.appendChild(id);      
      Element generator= document.createElement("generator");
      id.appendChild(generator);
      
      for(int i = 0; i < classFile.getAtributos().size();i++){
           Element atributo= document.createElement("property");
           atributo.setAttribute("name",  classFile.getAtributos().get(i));
            clase.appendChild(atributo);
          
      }
     

     
    
    }
    public void GenerarXml(String nombrearchiv) throws TransformerConfigurationException, IOException, TransformerException{
    TransformerFactory factoria=TransformerFactory.newInstance();
    Transformer transformer=factoria.newTransformer();
    Source source = new DOMSource(document);
    File fich= new File(nombrearchiv+".hbm.xml");
    FileWriter fw= new FileWriter(fich);
    PrintWriter pw=new PrintWriter(fw);
    Result resultado= new StreamResult(pw);
    transformer.transform(source, resultado);
    
    
    }
    
}
