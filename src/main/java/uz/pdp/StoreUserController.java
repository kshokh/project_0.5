package uz.pdp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/store")
@SecurityRequirement(name = "bearerAuth")
public class StoreUserController {

    @Operation(
            summary = "Get Store By ID",
            description = "Fetch store details using store ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful Retrieval",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Store.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Store Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore( @PathVariable Long id ) {

        Store store = new Store();
        store.setId( id );
        store.setName( "Demo Store" );
        store.setEmail( "demo@store.com" );
        store.setEmployeeCount( 10 );
        store.setDesc( "Demo Description" );

        return ResponseEntity.ok( store );
    }
}
