package com.example.venueeventbackend;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    List<Event> events = new ArrayList<>();

    private long id = 0;
    List<String> performers = List.of("Performer 1", "Performer 2", "Performer 3");
    List<String> tags = List.of("Tag 1", "Tag 2", "Tag 3");
    LocalDate datexample = LocalDate.of(1990, 5, 15);
    //generating fake data for testing with postman;
    public EventService() {
        this.events.add(new Event(this.id++,"Dance party","Swing around bestie!",100,"image.png", datexample,"Lorem ipsum di amet",performers,tags,true,false));
        this.events.add(new Event(this.id++,"Poetry practice","Beats walking!",200,"image.png",datexample,"Lorem ipsum di amet",performers,tags,false,false));
        this.events.add(new Event(this.id++,"Shouting match","Feels like home!", 300,"image.png",datexample,"lorem ipsum di amet", performers,tags,false,false));
    }

    public List<Event> getEventsList() {return this.events;}

    public Event getEventById(long id) {
        for (Event event : this.events) {
            if(event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getFlagged() {
        return events.stream()
                .filter(Event::isFlag) //thank you lombok!
                .collect(Collectors.toList());
    }

    public void DeleteEvent(long id) {
        List<Event> eventList = this.events;
        for(int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            if(event.getId() == id) {
                this.events.remove(i);
                return;
            }
        }
    }

    public Event createEvent(Event event) {
        event.setId(this.id++);
        this.events.add(event);
        return event;
    }

    public Optional<Event> getEventHeadInfo(long eventId) { // I used Optional<> to avoid null references when returning the head; i did this to avoid creating a separate class for the Eventhead.
        Event event = getEventById(eventId);

        if (event != null) {
            event.setVenue(0);
            event.setPerformers(null);
            event.setTags(null);
            event.setIzdvojeno(false);
            event.setFlag(false);

            return Optional.of(event);
        } else {
            return Optional.empty();
        }
    }

 /*No update service yet as that will be implemented later */



}
