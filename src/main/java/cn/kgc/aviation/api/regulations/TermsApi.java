package cn.kgc.aviation.api.regulations;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Terms;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序显示条款的接口")
public interface TermsApi {
    @ApiIgnore
    Result getTerms(Integer rid, Integer currentPage, Integer pageSize);

    @ApiOperation(value = "显示条款内容", notes = "根据条款id显示查询条款",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "tid", value = "条款id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getTermsById(Integer tid);

    @ApiIgnore
    Result delTerms(Integer tid) throws Exception;

    @ApiIgnore
    Result updateTerms(@RequestBody Terms terms);

    @ApiIgnore
    Result addTerms(@RequestBody Terms terms);

    @ApiOperation(value = "显示所属条款", notes = "根据目录id显示所属所有条款",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "did", value = "目录id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getTermsByDid(Integer did);

    @ApiOperation(value = "模糊查询", notes = "通过关键字模糊查询条款",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "keyWord", value = "关键字", dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getTermsByKeyWord(String keyWord);
}
