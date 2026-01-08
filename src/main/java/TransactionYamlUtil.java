
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;

public class TransactionYamlUtil {

    private static ObjectMapper yamlMapper() {
        ObjectMapper mapper = new ObjectMapper( new YAMLFactory() );
        mapper.registerModule( new JavaTimeModule() );
        return mapper;
    }

    public static void writeToYaml( Transaction tx, File file ) throws Exception {
        yamlMapper().writeValue( file, tx );
    }

    public static Transaction readFromYaml( File file ) throws Exception {
        return yamlMapper().readValue( file, Transaction.class );
    }
}
