package com.inftga.backend.core.event;


import java.util.Date;

/**
 * For tracking
 */
public abstract class Event {

    private Date date;

    public Event(){
        this.date = new Date();
    }
}
