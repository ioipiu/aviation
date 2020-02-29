package cn.kgc.aviation.api.collect;

import cn.kgc.aviation.model.dto.Result;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序添加取消收藏的接口")
public interface CollectApi {

    @ApiOperation(value = "首页显示的收藏", notes = "默认首页显示的5条收藏条款",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getCollectionByUid(String uid);

    @ApiOperation(value = "我的收藏", notes = "显示我所有的收藏条款",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getAllCollection(String uid);

    @ApiIgnore
    Result getCollectionByCid(Integer cid);

    @ApiOperation(value = "添加收藏", notes = "点击收藏按钮收藏",httpMethod ="POST",response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String"),
            @ApiImplicitParam(name = "tid", value = "条款id Integer", dataType = "Integer")

    })
    @ApiResponses({
            @ApiResponse(code = 2001, message = "登录成功"),
            @ApiResponse(code = 3001, message = "登录失败")
    })
    Result addCollection(String uid, Integer tid);

    @ApiOperation(value = "取消收藏", notes = "修改收藏状态为未收藏",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "cid", value = "收藏id Integer", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "取消成功"),
            @ApiResponse(code = 3001, message = "取消失败")
    })
    Result delCollection(Integer cid);

    @ApiOperation(value = "获取收藏状态", notes = "进入条款判断该用户是否收藏过该条款以及收藏状态",httpMethod ="POST",response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String"),
            @ApiImplicitParam(name = "tid", value = "条款id Integer", dataType = "Integer")

    })
    @ApiResponses({
            @ApiResponse(code = 2001, message = "取消成功"),
            @ApiResponse(code = 3001, message = "取消失败")
    })
    Result getCollect(String uid, Integer tid);
}
