package com.example.venueeventbackend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Performer {
    private long id;

    private String name;

    private String slogan;

    private String imageId;

    private String aboutMe;

    private String performerType; //stores the type of performer; musician, clown, public speaker or what?


}
