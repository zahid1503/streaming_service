package com.example.streamXpress.entities;

public enum Plan {
    MONTHLY("Monthly",1),
    BI_ANNUAL("Bi-Annual",6),
    ANNUAL("Annual",12);

    private String displayName;

    private Integer duration;

    Plan(String displayName, Integer duration) {
        this.displayName = displayName;
        this.duration = duration;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Integer getDuration() {
        return duration;
    }
}
