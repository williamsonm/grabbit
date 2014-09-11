package com.twc.webcms.sync.client.servlets

import com.twc.webcms.sync.client.services.SyncClientService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.apache.felix.scr.annotations.sling.SlingServlet
import org.apache.felix.scr.annotations.Reference
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.apache.sling.api.servlets.SlingSafeMethodsServlet

import javax.servlet.ServletException

@CompileStatic
@Slf4j
@SlingServlet( methods = ['GET'], paths = ["/bin/client/sync"] )
class SyncClientServlet extends SlingSafeMethodsServlet {

    @Reference(bind = 'setSyncClientService')
    SyncClientService syncClientService


    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        final String rootPath = request.queryString.split("=")[1]
        syncClientService.doSync(rootPath)
    }
}