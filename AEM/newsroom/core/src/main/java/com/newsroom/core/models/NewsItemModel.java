// File: core/src/main/java/com/newsroom/core/models/NewsItemModel.java
package com.newsroom.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class NewsItemModel {
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String imageRef;

    @ValueMapValue
    private String publishedDate;

    @ValueMapValue
    private String source;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageRef() {
        return imageRef;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }
}