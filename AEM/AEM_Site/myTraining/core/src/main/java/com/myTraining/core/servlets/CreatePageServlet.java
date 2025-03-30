package com.myTraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Page;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/myTraining/createPage",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET
        }
)
public class CreatePageServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreatePageServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        String pageName = request.getParameter("pageName");

        if (pageName == null || pageName.trim().isEmpty()) {
            response.getWriter().write("Error: Please provide a 'pageName' parameter.");
            return;
        }

        try {
            PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
            String parentPath = "/content/myTraining";
            String templatePath = "/conf/myTraining/settings/wcm/templates/page-content"; // Adjust based on your project
            Page newPage = pageManager.create(parentPath, pageName, templatePath, pageName, true);

            if (newPage != null) {
                response.getWriter().write("Page created successfully at: " + newPage.getPath());
                LOGGER.info("Page created at: {}", newPage.getPath());
            } else {
                response.getWriter().write("Failed to create page.");
            }
        } catch (Exception e) {
            LOGGER.error("Error creating page: {}", e.getMessage(), e);
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}