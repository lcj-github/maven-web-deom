package com.lcj.jetty;

import org.w3c.dom.Document;  
import org.xml.sax.SAXException;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.*;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  


public class XMLReaderHelper {
	
	private static Document document;  
	  
    //将xml文件转换为String，使用dom方式解析xml  
    public static String xmlStrReader(String fileName) {  
        try {  
            //获取DOM解析器工厂，以便生产解析器  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            //获取DOM解析器，以便解析DOM   
            DocumentBuilder db = dbf.newDocumentBuilder();  
              
            //把要解析的 XML 文档转化为输入流，以便 DOM 解析器解析它  
            //InputStream is= new  FileInputStream("test1.xml");   
              
            //解析 XML 文档的输入流，得到一个 Document  
            document = db.parse(fileName);  
  
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer t = tf.newTransformer();  
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            t.transform(new DOMSource(document), new StreamResult(bos));  
            String xmlStr = bos.toString();  
            return xmlStr;  
        } catch (ParserConfigurationException e) {  
            System.err.println(e.getMessage());  
        } catch (SAXException e) {  
            System.err.println(e.getMessage());  
        } catch (IOException e) {  
            System.err.println(e.getMessage());  
        } catch (TransformerConfigurationException e) {  
            System.err.println(e.getMessage());  
        } catch (TransformerException e) {  
            System.err.println(e.getMessage());  
        }  
        return null;  
    } 

}
