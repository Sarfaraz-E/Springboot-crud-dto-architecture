package com.example.demo.service.Impl;

import com.example.demo.dto.AddStudentRequestDto;
import com.example.demo.dto.studentDto;
import com.example.demo.entity.student;
import com.example.demo.repository.studentRepository;
import com.example.demo.service.studentService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor


public class studentServiceImpl implements studentService { //just write this then apply implementation
    private final studentRepository StudentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<studentDto> getAllStudents() {
        List<student> students = StudentRepository.findAll();
        return students.
                stream()
                .map(student -> modelMapper.map(student, studentDto.class))
                .toList();//List of students convert into studentDto for security purpose
        //Can also use for loop rahter than Stream

// Can Also Do this part new studentDto(student.getId(), student.getName(),student.getEmail()))
//                .toList(); with Model Mapper TYS
        //Using  model mapper dont need to write like all student.getId()

    }

    @Override
    public studentDto findById(Long id) {
        student studentEntity = StudentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found " + id));

        return modelMapper.map(studentEntity, studentDto.class);

    }

    @Override
    public studentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        // 1. Convert DTO → Entity
        student dtoStudent = modelMapper.map(addStudentRequestDto, student.class);
        student newStudent = StudentRepository.save(dtoStudent);
        return modelMapper.map(newStudent, studentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!StudentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student ID not Found" + id);
        }
        StudentRepository.deleteById(id);

    }

    @Override
    public studentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        student studentEntity = StudentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found " + id));
           modelMapper.map(addStudentRequestDto,studentEntity);
        studentEntity=StudentRepository.save(studentEntity);
        return modelMapper.map(studentEntity,studentDto.class);
    }

    @Override
    public studentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        student studentEntity = StudentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found " + id));
        updates.forEach((field,value)->{
            switch (field){
                case "name":studentEntity.setName((String) value);//value is object converting in string
                    break;
                case "email":studentEntity.setEmail((String) value);
                   break;
                default:
                    throw new IllegalArgumentException("Not found");
            }
        });
        student savedStudent=StudentRepository.save(studentEntity);
        return modelMapper.map(savedStudent,studentDto.class);
    }

}

