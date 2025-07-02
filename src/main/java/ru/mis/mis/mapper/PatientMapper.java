package ru.mis.mis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mis.mis.dto.PatientDto;
import ru.mis.mis.model.Patient;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDto toPatientDto(Patient patient);
    Patient toPatient(PatientDto patientDto);
}
