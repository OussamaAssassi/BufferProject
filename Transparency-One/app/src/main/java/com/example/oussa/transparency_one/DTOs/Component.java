package com.example.oussa.transparency_one.DTOs;

/**
 * Created by Simon.Budin on 29/09/2016.
 */

public class Component {

    public Component(String visibilityLevelName) {
        this.name = visibilityLevelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    private boolean danger;

}
