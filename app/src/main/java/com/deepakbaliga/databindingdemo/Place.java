package com.deepakbaliga.databindingdemo;


/**
 * Created by deezdroid on 03/10/15.
 */
public class Place {

    private final String name;
    private final String description;
    private final String imageLink;

    public Place(String name, String description, String imageLink) {
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLink() {
        return imageLink;
    }
}
