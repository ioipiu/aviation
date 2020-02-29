package cn.kgc.aviation.api.regulations;

import cn.kgc.aviation.model.dto.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序显示层级目录的接口")
public interface CascaderApi {
    @ApiIgnore
    Result showOptions();

    @ApiIgnore
    Result showDire();

    @ApiOperation(value = "显示目录", notes = "根据法规显示所在的目录",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "rid", value = "法规id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getDir(Integer rid);

    @ApiIgnore
    Result getReg();

    @ApiIgnore
    Result delDir(Integer rid, Integer did) throws Exception;
}
