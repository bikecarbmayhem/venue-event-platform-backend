package com.example.venueeventbackend;

import java.util.List;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private long id;

    private String eventName;

    private String subheading;

    private long venue; //stores venue id

    private String imageId;

    private LocalDate date;

    private String description;

    private List<String> performers;

    private List<String> tags;

    private boolean izdvojeno; //bool value that determines whether the certain

    private boolean flag; //marks the specific event for review; will be used in an admin panel to review. still on the rocks about this

}
