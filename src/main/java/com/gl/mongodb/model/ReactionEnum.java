package com.gl.mongodb.model;

import lombok.Getter;

@Getter
public enum ReactionEnum {
    LIKE("Like"),
    DISLIKE("Dislike");
    private final String displayName;

    ReactionEnum(String displayName) {
        this.displayName = displayName;
    }

}
