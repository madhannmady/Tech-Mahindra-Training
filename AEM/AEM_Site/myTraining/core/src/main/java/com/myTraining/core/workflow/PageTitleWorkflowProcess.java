package com.myTraining.core.workflow;


import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = WorkflowProcess.class,
        property = {"process.label=Print Page Title Process"}
)
public class PageTitleWorkflowProcess implements WorkflowProcess {
    private static final Logger LOG = LoggerFactory.getLogger(PageTitleWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap args) {
        try {
            String path = workItem.getWorkflowData().getPayload().toString();
            PageManager pageManager = workflowSession.adaptTo(PageManager.class);
            Page page = pageManager.getPage(path);
            if (page != null) {
                LOG.info("Page Title: {}", page.getTitle());
            }
        } catch (Exception e) {
            LOG.error("Error occurred: {}", e.getMessage());
        }
    }
}
