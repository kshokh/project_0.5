package uz.pdp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
@Schema(description = "Store Entity representing store details")
@Getter
@Setter
public class Store {

    @Min(1)
    @NotNull
    @Schema(description = "Store Identifier", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 120)
    @Schema(description = "Store Name", example = "ABC Super Store", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank
    @Size(min = 9, max = 250)
    @Schema(description = "Store Email Address", example = "store@abc.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotNull
    @Min(1)
    @Schema(description = "Number of Employees", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private int employeeCount;

    @Schema(description = "Store Description", example = "Main branch located in downtown")
    private String desc;
}
