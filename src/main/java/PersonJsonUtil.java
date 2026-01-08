
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class PersonJsonUtil {

    public static void writeToFile( Person person, File file ) throws Exception {
        new ObjectMapper().writeValue( file, person );
    }

    public static Person readFromFile( File file ) throws Exception {
        return new ObjectMapper().readValue( file, Person.class );
    }
}
