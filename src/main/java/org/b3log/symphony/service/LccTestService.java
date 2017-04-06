package org.b3log.symphony.service;

import org.b3log.latke.logging.Logger;
import org.b3log.latke.repository.RepositoryException;
import org.b3log.latke.service.annotation.Service;
import org.b3log.symphony.repository.LccTestRepository;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Created by Administrator on 17/3/27.
 */
@Service
public class LccTestService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(LccTestService.class.getName());
    @Inject
    private LccTestRepository lccTestRepository;

    public  String show(){
        LOGGER.info("in LccTestService show");
        try {
            //JSONObject object = lccTestRepository.getByName("");
           // LOGGER.debug(object.toString());
            JSONObject object = lccTestRepository.getByName("spring");
            LOGGER.debug(object.toString());
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return "service return msg";
    }

}
