
import com.fasterxml.jackson.databind.ObjectMapper;

public static List<Car> jsonToCars( String json ) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(
            json,
            mapper.getTypeFactory().constructCollectionType( List.class, Car.class )
    );
}

void main() {
}
