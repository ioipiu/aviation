package cn.kgc.aviation.service.setup;

import cn.kgc.aviation.model.entity.*;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-15 10:15
 * @version: V1.0
 **/
public interface SetupService {

    Introduction getIntro();

    Boolean updateIntro(Integer id, String desc);

    Agreement getAgree();

    Boolean updateAgree(Integer id, String content);

    Smtp getSmtp();

    Boolean updateSmtp(Smtp smtp);

    Sms getSms();

    Boolean updateSms(Integer id, String apiKey);

    Map<String, Object> showFeedback(Integer currentPage, Integer pageSize);

    Boolean delFeedback(String fid);

    Websettings getWebSet();

    Boolean updateWebSet(Websettings websettings);

    Boolean addFeedback(Feedback feedback);
}
