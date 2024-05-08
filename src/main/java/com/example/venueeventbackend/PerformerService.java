package com.example.venueeventbackend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerformerService {

    List<Performer> performers = new ArrayList<>();

    private long id = 0;

    public PerformerService() {
        this.performers.add(new Performer(this.id++,"John Doe","Better now than never!","image.png","Lorem ipsum di amet","Musician"));
        this.performers.add(new Performer(this.id++,"Dracula","I'm Dracula, I'm 12 million years old!","image.png","Lorem ipsum di amet","Public speaker"));
        this.performers.add(new Performer(this.id++, "Husejn Kapetan Gradascevic","how did i get here?","image.png","Lorem ipsum di amet","Motivational speaker"));
    }

    public List<Performer> getPerformersList() {return this.performers;}

    public Performer getPerformerById(long id) {
        for(Performer performer : this.performers) {
            if(performer.getId() == id) {
                return performer;
            }
        }
        return null;
    }

    public void DeletePerformer(long id) {
        List<Performer> performerList = this.performers;
        for(int i = 0; i < performerList.size(); i++) {
            Performer performer = performerList.get(i);
            if(performer.getId() == id) {
                this.performers.remove(i);
                return;
            }
        }
    }

    public Performer createPerformer(Performer performer) {
        performer.setId(this.id++);
        this.performers.add(performer);
        return performer;
    }

    public Performer updatePerformer(Long id, Performer performer) {
        Performer current = this.getPerformerById(id);
        if(current == null) {
            return null;
        }

        current.setName(performer.getName());
        current.setSlogan(performer.getSlogan());
        current.setImageId(performer.getImageId());
        current.setAboutMe(performer.getAboutMe());
        current.setPerformerType(performer.getPerformerType());

        return current;
    }


}
