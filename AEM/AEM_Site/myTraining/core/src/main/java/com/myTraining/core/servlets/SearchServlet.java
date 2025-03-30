package com.myTraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

import javax.jcr.Session;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/myTraining/search",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET
        }
)
public class SearchServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServlet.class);

    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        String searchTerm = request.getParameter("query");

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            response.getWriter().write("Error: Please provide a 'query' parameter.");
            return;
        }

        try {
            Session session = request.getResourceResolver().adaptTo(Session.class);
            Map<String, String> predicates = new HashMap<>();
            predicates.put("type", "cq:PageContent");
            predicates.put("path", "/content/myTraining");
            predicates.put("fulltext", searchTerm);
            predicates.put("p.limit", "-1"); // No limit on results

            Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);
            SearchResult result = query.getResult();

            StringBuilder output = new StringBuilder("Search results for '" + searchTerm + "':\n");
            result.getHits().forEach(hit -> {
                try {
                    output.append("- ").append(hit.getPath()).append("\n");
                } catch (Exception e) {
                    LOGGER.error("Error processing hit: {}", e.getMessage(), e);
                }
            });

            response.getWriter().write(output.toString());
            LOGGER.info("Search executed for term: {}", searchTerm);
        } catch (Exception e) {
            LOGGER.error("Error during search: {}", e.getMessage(), e);
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}