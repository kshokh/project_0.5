
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main( String[] args ) throws Exception {

        ObjectMapper jsonMapper = new ObjectMapper();

        // -----------------------------
        // 1️⃣ Work with Car
        // -----------------------------
        Car car1 = new Car( "Red", "Sedan", "INTERNAL123" );
        Car car2 = new Car( "Blue", "SUV", "INTERNAL456" );

        List<Car> cars = Arrays.asList( car1, car2 );

        String carsJson = jsonMapper.writeValueAsString( cars );
        System.out.println( "Cars JSON:\n" + carsJson );

        List<Car> readCars = jsonMapper.readValue(
                carsJson,
                jsonMapper.getTypeFactory().constructCollectionType( List.class, Car.class )
        );
        System.out.println( "\nRead Cars from JSON:" );
        readCars.forEach( System.out::println );

        // -----------------------------
        // 2️⃣ Work with Person (immutable)
        // -----------------------------
        Person person1 = new Person( "John", "Doe", 30 );
        Person person2 = new Person( "Jane", "Smith", 25 );

        List<Person> people = Arrays.asList( person1, person2 );

        XmlMapper xmlMapper = new XmlMapper();
        File personFile = new File( "people.xml" );

        xmlMapper.writeValue( personFile, people );
        System.out.println( "\nPerson list written to people.xml" );

        List<Person> readPeople = xmlMapper.readValue(
                personFile,
                xmlMapper.getTypeFactory().constructCollectionType( List.class, Person.class )
        );
        System.out.println( "Read People from XML:" );
        readPeople.forEach( System.out::println );
    }
}
