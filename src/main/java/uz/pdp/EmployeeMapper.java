package uz.pdp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    @Mapping(source = "employeeId", target = "id")
    @Mapping(source = "employeeName", target = "name")
    Employee toEntity(EmployeeDTO dto);


    @Mapping(source = "id", target = "employeeId")
    @Mapping(source = "name", target = "employeeName")
    EmployeeDTO toDto(Employee employee);
}