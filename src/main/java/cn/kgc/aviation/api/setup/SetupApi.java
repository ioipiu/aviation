package cn.kgc.aviation.api.setup;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Feedback;
import cn.kgc.aviation.model.entity.Smtp;
import cn.kgc.aviation.model.entity.Websettings;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序意见反馈、公司介绍、服务条款的接口")
public interface SetupApi {
    @ApiOperation(value = "公司介绍", notes = "获取公司介绍",httpMethod ="GET",response = Result.class)
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getIntro();

    @ApiIgnore
    Result updateIntro(Integer id, String desc);

    @ApiOperation(value = "服务条款", notes = "获取服务条款",httpMethod ="GET",response = Result.class)
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getAgree();

    @ApiIgnore
    Result updateAgree(Integer id, String content);

    @ApiIgnore
    Result getSmtp();

    @ApiIgnore
    Result updateSmtp(@RequestBody Smtp smtp);

    @ApiIgnore
    Result getSms();

    @ApiIgnore
    Result updateSms(Integer id, String apiKey);

    @ApiIgnore
    Result showFeedback(Integer currentPage, Integer pageSize);

    @ApiIgnore
    Result delFeedback(String fid);

    @ApiIgnore
    Result getWebSet();

    @ApiIgnore
    Result updateWebSet(@RequestBody Websettings websettings);

    @ApiOperation(value = "意见反馈", notes = "客户意见反馈",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "Feedback", value = "意见反馈对象", dataType = "Feedback")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "反馈成功"),
            @ApiResponse(code = 3001, message = "反馈失败")
    })
    Result addFeedback(Feedback feedback);
}
