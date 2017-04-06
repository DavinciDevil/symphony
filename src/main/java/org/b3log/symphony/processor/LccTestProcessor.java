package org.b3log.symphony.processor;

import org.b3log.latke.servlet.HTTPRequestContext;
import org.b3log.latke.servlet.HTTPRequestMethod;
import org.b3log.latke.servlet.annotation.After;
import org.b3log.latke.servlet.annotation.Before;
import org.b3log.latke.servlet.annotation.RequestProcessing;
import org.b3log.latke.servlet.annotation.RequestProcessor;
import org.b3log.latke.servlet.renderer.freemarker.AbstractFreeMarkerRenderer;
import org.b3log.symphony.processor.advice.PermissionGrant;
import org.b3log.symphony.processor.advice.stopwatch.StopwatchEndAdvice;
import org.b3log.symphony.processor.advice.stopwatch.StopwatchStartAdvice;
import org.b3log.symphony.service.DataModelService;
import org.b3log.symphony.service.LccTestService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 17/3/27.
 */
@RequestProcessor
public class LccTestProcessor {

    @Inject
    LccTestService lccTestService;

    /**
     * Data model service.
     */
    @Inject
    private DataModelService dataModelService;

    @RequestProcessing(value = "/lcctest/showmsg",method = HTTPRequestMethod.GET)
    @Before(adviceClass = StopwatchStartAdvice.class)
    @After(adviceClass = {PermissionGrant.class, StopwatchEndAdvice.class})
    public void showMSG(final HTTPRequestContext context,
                        final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final AbstractFreeMarkerRenderer renderer = new SkinRenderer(request);
        context.setRenderer(renderer);
        renderer.setTemplateName("/lcctest/showmsg.ftl");
        final Map<String,Object> dataModel = renderer.getDataModel();
        String msg = lccTestService.show();
        dataModel.put("msg",msg);
        dataModelService.fillHeaderAndFooter(request,response,dataModel);
        dataModelService.fillIndexTags(dataModel);
    }
}
