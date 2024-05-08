package com.example.venueeventbackend;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("events")
@RestController
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("list")
    public List<Event> getEvents() { return this.eventService.getEventsList();}

    @GetMapping("flagged")
    public List<Event> getFlaggedEvents() {
        return eventService.getFlagged();
    }

    @GetMapping("{id}")
    public Event getEvents(@PathVariable Long id) { return this.eventService.getEventById(id);}

    @PostMapping()
    public Event CreateEvent(@RequestBody Event event) {
        return this.eventService.createEvent(event);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headEvent(@PathVariable long id) {
        Optional<Event> eventOptional = eventService.getEventHeadInfo(id);

        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Image-Id", event.getImageId());
            headers.add("Event-Name", event.getEventName());
            headers.add("Date", event.getDate().toString());
            headers.add("Description", event.getDescription());

            return ResponseEntity.ok().headers(headers).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /*
    @PutMapping("{id}")
    public Event updateEvent(@Pathva)
    */

}
