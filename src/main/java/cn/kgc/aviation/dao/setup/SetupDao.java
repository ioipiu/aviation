package cn.kgc.aviation.dao.setup;

import cn.kgc.aviation.model.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SetupDao {

    Introduction getIntro();

    int updateIntro(@Param("id") Integer id, @Param("desc") String desc);

    Agreement getAgree();

    int updateAgree(@Param("id") Integer id, @Param("content") String content);

    Smtp getSmtp();

    int updateSmtp(@Param("smtp") Smtp smtp);

    Sms getSms();

    int updateSms(@Param("id") Integer id, @Param("apiKey") String apiKey);

    List<Feedback> showFeedback(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Integer getFeedbackCount();

    int delFeedback(@Param("fid") String fid);

    Websettings getWebSet();

    int updateWebSet(@Param("webset") Websettings websettings);
}
