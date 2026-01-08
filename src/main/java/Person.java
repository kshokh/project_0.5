
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(String firstName, String lastName, int age) {

    @JsonCreator
    public Person(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") int age ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
