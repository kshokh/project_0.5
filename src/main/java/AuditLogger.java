
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditLogger {

    @PostPersist
    public void onCreate( Object entity ) {
        log.info( "Created entity: {}", entity );
    }

    @PostUpdate
    public void onUpdate( Object entity ) {
        log.info( "Updated entity: {}", entity );
    }

    @PostRemove
    public void onDelete( Object entity ) {
        log.info( "Deleted entity: {}", entity );
    }
}
