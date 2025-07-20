package com.syntaticsuger.notes.controller;

import com.syntaticsuger.notes.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NoteController {
    List<Note> notes = new ArrayList<>();
    private static int id = 0;

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloMessage() {
        return new ResponseEntity<String>("This  is my first api", HttpStatus.OK);
    }

    @GetMapping("/note")
    public ResponseEntity<List<Note>> getNote() {
        return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
    }

    @PostMapping("/note")
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        note.setId(++id);
        notes.add(note);
        return new ResponseEntity<String>("Note created successfully", HttpStatus.CREATED);
    }

    //update
    @PutMapping("/note/{id}")
    public ResponseEntity<String> updateNote(@RequestBody Note note, @PathVariable int id) {
        // iterate over array get matching id and delete it
        Note noteToDelete = null;
        for (Note n : notes) {

            if (n.getId() == id) {
                noteToDelete = n;
            }
        }

        if (noteToDelete != null) {
            notes.remove(noteToDelete);
            note.setId(id);
            notes.add(note);
            return new ResponseEntity<String>("Note updated successfully", HttpStatus.CREATED);

        } else {
            return new ResponseEntity<String>("Note not found with id " + id, HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) {
        Note noteToDelete = null;
        for (Note n : notes) {

            if (n.getId() == id) {
                noteToDelete = n;
            }
        }

        if (noteToDelete != null) {
            notes.remove(noteToDelete);
            return new ResponseEntity<String>("Note deleted successfully", HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<String>("Note not found with id " + id, HttpStatus.NOT_FOUND);
        }

    }
}
