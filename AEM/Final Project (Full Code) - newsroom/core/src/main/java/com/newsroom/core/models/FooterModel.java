package com.newsroom.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(FooterModel.class);

    @Self
    private Resource resource;

    @Inject
    private ResourceResolver resourceResolver;

    public static class NewsItem {
        public String title;
        public String path;

        public NewsItem(String title, String path) {
            this.title = title;
            this.path = path;
        }
    }

    public List<NewsItem> getLatestNews() {
        List<NewsItem> latestNews = new ArrayList<>();
        LOGGER.debug("Fetching news pages from /content/newsroom/us/en/news");
        Resource newsRoot = resourceResolver.getResource("/content/newsroom/us/en/news");

        if (newsRoot != null) {
            LOGGER.debug("News root found: {}", newsRoot.getPath());
            for (Resource newsPage : newsRoot.getChildren()) {
                ValueMap properties = newsPage.getValueMap();
                String title = properties.get("jcr:title", String.class);
                String path = newsPage.getPath() + ".html";
                LOGGER.debug("Found news page: {} with title: {}", path, title);

                if (title != null) {
                    latestNews.add(new NewsItem(title, path));
                }
            }
        } else {
            LOGGER.warn("News root not found at /content/newsroom/us/en/news");
        }

        Collections.reverse(latestNews); // Show the most recent first
        LOGGER.debug("Total news items fetched: {}", latestNews.size());
        return latestNews.size() > 5 ? latestNews.subList(0, 5) : latestNews;
    }
}