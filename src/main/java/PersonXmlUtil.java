
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;

public class PersonXmlUtil {

    public static void writeListToXml( List<Person> people, File file ) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue( file, people );
    }

    public static List<Person> readListFromXml( File file ) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(
                file,
                xmlMapper.getTypeFactory().constructCollectionType( List.class, Person.class )
        );
    }
}
