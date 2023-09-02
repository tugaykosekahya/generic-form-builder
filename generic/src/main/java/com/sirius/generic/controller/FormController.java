package com.sirius.generic.controller;


import com.sirius.generic.Entity.Form;
import com.sirius.generic.Services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping
    public ResponseEntity<Form> createForm(@RequestBody Form form) {
        Form savedForm = formService.saveForm(form);
        return ResponseEntity.ok(savedForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Form> getFormById(@PathVariable Long id) {
        Form form = formService.getFormById(id);
        if (form != null) {
            return ResponseEntity.ok(form);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Form>> getAllForms() {
        List<Form> forms = formService.getAllForms();
        return ResponseEntity.ok(forms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        formService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }

}
