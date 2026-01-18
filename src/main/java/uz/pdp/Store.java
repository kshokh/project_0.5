package uz.pdp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Positive
    private Integer employeeCount;

    private String description;
}
