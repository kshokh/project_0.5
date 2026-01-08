
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "updatedAt",
        "createdAt",
        "status",
        "amount",
        "id"
})
@Getter
@Setter
public class Transaction {

    private Long id;
    private BigDecimal amount;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
