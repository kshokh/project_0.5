
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeReader {

    public static String getAmountAndStatus( String json ) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree( json );

        String amount = node.get( "amount" ).asText();
        String status = node.get( "status" ).asText();

        return "amount=" + amount + ", status=" + status;
    }
}
