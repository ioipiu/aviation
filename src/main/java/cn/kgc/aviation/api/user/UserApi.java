package cn.kgc.aviation.api.user;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "这是小程序登录注册及咨询的接口")
public interface UserApi {

    @ApiIgnore
    Result showUsers(Integer currentPage, Integer pageSize);

    @ApiIgnore
    Result updateUser(@RequestBody Users users);

    @ApiIgnore
    Result showCons(Integer currentPage, Integer pageSize);

    @ApiIgnore
    Result delCon(String zid);

    @ApiOperation(value = "登录", notes = "使用手机号与密码登录",httpMethod ="POST",response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")

    })
    @ApiResponses({
            @ApiResponse(code = 2001, message = "登录成功"),
            @ApiResponse(code = 3001, message = "登录失败")
    })
    Result login(String mobile, String password);

    @ApiOperation(value = "注册", notes = "使用手机号注册",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "Users", value = "用户对象", dataTypeClass = Users.class)
    @ApiResponses({
            @ApiResponse(code = 2001, message = "注册成功"),
            @ApiResponse(code = 3001, message = "注册失败")
    })
    Result register(Users users);

    @ApiOperation(value = "修改密码", notes = "通过旧密码修改",httpMethod ="POST",response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPwd", value = "原密码", dataType = "String"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", dataType = "String"),
            @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String")

    })
    @ApiResponses({
            @ApiResponse(code = 2001, message = "修改成功"),
            @ApiResponse(code = 3001, message = "修改失败")
    })
    Result changePwd(String oldPwd, String newPwd, String uid);

    @ApiOperation(value = "咨询", notes = "咨询服务",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "Consulting", value = "咨询对象", dataType = "Consulting")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "提交成功"),
            @ApiResponse(code = 3001, message = "提交失败")
    })
    Result addCon(Consulting consulting);

    @ApiOperation(value = "历史咨询", notes = "获取历史咨询列表",httpMethod ="POST",response = Result.class)
    @ApiImplicitParam(name = "uid", value = "用户id", dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 2001, message = "获取成功"),
            @ApiResponse(code = 3001, message = "获取失败")
    })
    Result getConByUid(String uid);
}
