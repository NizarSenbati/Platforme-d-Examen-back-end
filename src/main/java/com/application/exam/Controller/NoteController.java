package com.application.exam.Controller;

import com.application.exam.Model.Note;
import com.application.exam.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Get all notes
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    // Get a specific note by ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        Optional<Note> note = noteService.getById(id);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new note
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note savedNote = noteService.saveNote(note);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    // Update a note by ID
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody Note note) {
        try {
            Note updatedNote = noteService.updateNote(id, note);
            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a note by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        try {
            noteService.deleteNote(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
