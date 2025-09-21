package com.example.demo.controller;

import com.example.demo.dto.AddStudentRequestDto;
import com.example.demo.dto.studentDto;
import com.example.demo.service.studentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class studentController {


    private final studentService StudentService;


    @GetMapping("/students")
    public ResponseEntity<List<studentDto>> showAllStudents() {//Using Response Entity to show diff types of  status codes ok 200Status in show
//        return ResponseEntity.status(HttpStatus.OK).body(StudentService.getAllStudents()); Or
        return ResponseEntity.ok(StudentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<studentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(StudentService.findById(id));
    }


    //Created  Status code 201
    @PostMapping("/Student")
    public ResponseEntity<studentDto> addStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentService.createNewStudent(addStudentRequestDto));
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        StudentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<studentDto> updateStudent(@PathVariable Long id,@RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
       return ResponseEntity.ok(StudentService.updateStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<studentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object> updates) {
        return ResponseEntity.ok(StudentService.updatePartialStudent(id,updates));
    }
}