
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentImportService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    public StudentImportService( StudentRepository studentRepository,
                                 GroupRepository groupRepository,
                                 ObjectMapper objectMapper ) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    public void importStudents( File file ) throws IOException {
        List<Student> students =
                Arrays.asList( objectMapper.readValue( file, Student[].class ) );
        studentRepository.saveAll( students );
    }
}
