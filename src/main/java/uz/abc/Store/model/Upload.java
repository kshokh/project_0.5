package uz.abc.Store.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upload {

    private String originalName;
    private String generatedName;
    private long size;
    private String mimeType;
    private String uploadedPath;
}
