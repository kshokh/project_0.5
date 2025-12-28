
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path root = Paths.get( "uploads" );

    public Upload upload( MultipartFile file ) throws Exception {

        if ( !Files.exists( root ) ) {
            Files.createDirectories( root );
        }

        String generatedName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = root.resolve( generatedName );

        Files.copy( file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING );

        return new Upload(
                file.getOriginalFilename(),
                generatedName,
                file.getSize(),
                file.getContentType(),
                filePath.toString()
        );
    }

    public byte[] download( String fileName ) throws Exception {
        Path filePath = root.resolve( fileName );
        return Files.readAllBytes( filePath );
    }
}
