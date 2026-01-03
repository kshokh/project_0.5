package uz.abc.Store.controller;

import uz.abc.Store.service.FileStorageService;
import uz.abc.Store.model.Upload;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileStorageService fileService;

    public FileController( FileStorageService fileService ) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public Upload upload( @RequestPart MultipartFile file ) throws Exception {
        return fileService.upload( file );
    }

    @GetMapping("/download/{fileName}")
    public byte[] download( @PathVariable String fileName ) throws Exception {
        return fileService.download( fileName );
    }
}
