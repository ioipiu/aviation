package cn.kgc.aviation.api.regulations;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序显示法规的接口")
public interface RegApi {
    @ApiOperation(value = "显示法规一级分类", notes = "一级分类",httpMethod ="GET",response = Result.class)
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result showType();

    @ApiIgnore
    Result addType(String typeName);

    @ApiOperation(value = "显示法规二级分类", notes = "根据法规一级id显示二级分类",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "typeId", value = "法规一级id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result showClassify(Integer typeId);

    @ApiIgnore
    Result addClassify(Integer typeId, String classifyName);

    @ApiIgnore
    Result updateClassify(@RequestBody RegulationsClassify regulationsClassify);

    @ApiIgnore
    Result delClassify(Integer classifyId) throws Exception;

    @ApiIgnore
    Result getAll(Integer currentPage, Integer pageSize);

    @ApiIgnore
    Result delReg(Integer rid) throws Exception;

    @ApiIgnore
    Result getRegById(Integer rid);

    @ApiIgnore
    Result updateReg(@RequestBody Regulations regulations);

    @ApiIgnore
    Result addReg(@RequestBody Regulations regulations);

    @ApiIgnore
    Result getToken();

    @ApiIgnore
    Result delType(Integer typeId) throws Exception;

    @ApiOperation(value = "显示法规二级分类及所属法规", notes = "根据法规一级id查询",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "typeId", value = "法规一级id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getRegsByTypeId(Integer typeId);
}
