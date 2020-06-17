package com.amit.rest.webservices.worklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class WorkListResource {

    @Autowired
    private WorkListService workListService;

    @GetMapping("/users/{username}/worklist")
    public List<Work> getAllWorkList(@PathVariable String username) {
        return workListService.getWorkList();
    }

    @GetMapping("/users/{username}/worklist/{id}")
    public Work getWorkById(@PathVariable String username, @PathVariable int id ) {
        return workListService.findWorkById(id);
    }

    @DeleteMapping("/users/{username}/worklist/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username,@PathVariable int id) {
        Work work = workListService.deleteById(id);
        if(work != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/users/{username}/worklist")
    public ResponseEntity<Work> addWork(@PathVariable String username, @RequestBody Work work) {
        Work work1 = workListService.addWork(work);
        if(work1 != null) {
            return new ResponseEntity<>(work1, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/users/{username}/worklist/{id}")
    public ResponseEntity<Work> updateWork(@PathVariable String username,@PathVariable int id,@RequestBody Work work) {
        System.out.println("username "+username+" id "+id+" details "+ work.getDescription());
        Work work1 = workListService.updateWork(work,id);
        if(work1 != null) {
            return new ResponseEntity<Work>(work1, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
