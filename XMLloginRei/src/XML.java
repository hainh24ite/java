import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XML {
    public static List<User> importXML(String fileName) throws Exception{
        List<User> users = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbFactory.newDocumentBuilder();
        Document dc=db.parse(new File(fileName));
        NodeList nList = dc.getElementsByTagName("user");
        for (int i = 0; i < nList.getLength(); i++) {
            Element element = (Element) nList.item(i);
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            String tdn=element.getElementsByTagName("tendangnhap").item(0).getTextContent();
            int tuoi=Integer.parseInt(element.getElementsByTagName("tuoi").item(0).getTextContent());
            users.add(new User(name,tdn,null,tuoi));
        }
        return users;
    }

    public static void exportXML(List<User> users, String file) throws Exception{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbFactory.newDocumentBuilder();
        Document dc=db.newDocument();
        Element root = dc.createElement("userss");
        dc.appendChild(root);

        for(User user:users){
            Element userElement = dc.createElement("user");

            Element name = dc.createElement("name");
            name.appendChild(dc.createTextNode(user.getName()));
            userElement.appendChild(name);

            Element tdn = dc.createElement("tendangnhap");
            tdn.appendChild(dc.createTextNode(user.getTnd()));
            userElement.appendChild(tdn);

            Element tuoi = dc.createElement("tuoi");
            tuoi.appendChild(dc.createTextNode(String.valueOf(user.getTuoi())));
            userElement.appendChild(tuoi);

            root.appendChild(userElement);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(dc);
        StreamResult result = new StreamResult(new File(file));
        transformer.transform(source, result);
    }
}
