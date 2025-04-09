package com.newsroom.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class JournalistModel {

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String profileImage;

    @ValueMapValue
    private String bio;

    @ValueMapValue
    private String experience;

    @ValueMapValue
    private String email;

    public String getName() {
        return name != null ? name : "Journalist Name";
    }

    public String getProfileImage() {
        return profileImage != null ? profileImage : "";
    }

    public String getBio() {
        return bio != null ? bio : "No bio available.";
    }

    public String getExperience() {
        return experience != null ? experience : "Not specified.";
    }

    public String getEmail() {
        return email != null ? email : "Not specified.";
    }

    public String getEmailLink() {
        return email != null ? "mailto:" + email : "#";
    }
}