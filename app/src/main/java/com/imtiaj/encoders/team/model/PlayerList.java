package com.imtiaj.encoders.team.model;

import java.util.List;

public class PlayerList {
    private List<PlayerChildObject> data;

    public PlayerList(List<PlayerChildObject> data) {
        this.data = data;
    }

    public List<PlayerChildObject> getData() {
        return data;
    }

    public void setData(List<PlayerChildObject> data) {
        this.data = data;
    }
}

