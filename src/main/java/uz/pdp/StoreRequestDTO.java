package uz.pdp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Schema(description = "Store Request DTO")
@Getter
public class StoreRequestDTO {

    @NotBlank
    @Schema(description = "Store Name", example = "XYZ Mart")
    private String name;

    @NotBlank
    @Schema(description = "Store Email", example = "xyz@mart.com")
    private String email;

    @Min(1)
    @Schema(description = "Employee Count", example = "15")
    private int employeeCount;

    @Schema(description = "Description", example = "Neighborhood grocery store")
    private String desc;
}
