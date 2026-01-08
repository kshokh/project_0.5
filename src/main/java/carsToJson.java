
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public static String carsToJson( List<Car> cars) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(cars);
}

void main() {
}
