package com.example.demo.service;

import com.example.demo.dto.AddStudentRequestDto;
import com.example.demo.dto.studentDto;

import java.util.List;
import java.util.Map;

public interface studentService {

    List<studentDto> getAllStudents();

    studentDto findById(Long id);

    studentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    studentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    studentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
