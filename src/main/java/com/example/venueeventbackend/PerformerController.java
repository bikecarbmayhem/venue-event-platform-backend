package com.example.venueeventbackend;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("performers")
@RestController
public class PerformerController {
    private PerformerService performerService;

    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }

    @GetMapping("list")
    public List<Performer> getPerformers() { return this.performerService.getPerformersList(); }

    @GetMapping("{id}")
    public Performer getPerformers(@PathVariable Long id) { return this.performerService.getPerformerById(id);}

    @PostMapping
    public Performer CreatePerformer(@RequestBody Performer performer) {
        return this.performerService.createPerformer(performer);
    }

    @PutMapping("{id}")
    public Performer updatePerformer(@PathVariable Long id, @RequestBody Performer performer) { return this.performerService.updatePerformer(id,performer); }

}
