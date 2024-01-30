package ning.markerhub.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import ning.markerhub.base.lang.Consts;
import ning.markerhub.base.lang.Result;
import ning.markerhub.controller.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Controller
public class LoginController extends BaseController{
    /**
     * 1、获取验证码
     */
    @GetMapping(value = "/login")
    public String login(HttpServletRequest req) {
        String code = "DY" + RandomUtil.randomNumbers(4);
        while (redisUtil.hasKey(code)) {//因为只有四位验证码，很容易重复。这是为了避免重复
            code = "DY" + RandomUtil.randomNumbers(4);
        }
        String ticket = RandomUtil.randomString(32);
        // 5 min
        redisUtil.set(code, ticket, 5 * 60);

        req.setAttribute("code", code);
        req.setAttribute("ticket", ticket);
        log.info(code + "---" + ticket);
        return "login";
    }
    @ResponseBody
    @GetMapping("/login-check")
    public Result loginCheck(String code, String ticket) {

        // 校验逻辑后面写
        if (!redisUtil.hasKey("Info-" + code)) {
            return Result.failure("用户未登录");
        }

        String ticketBak = redisUtil.get("ticket-" + code).toString();
        if (!ticketBak.equals(ticket)) {
            return Result.failure("登录失败");
        }

        String userJson = redisUtil.get("Info-" + code).toString();
        UserDto userDto = JSONUtil.toBean(userJson, UserDto.class);
        req.getSession().setAttribute(Consts.CURRENT_USER, userDto);

        return Result.success();
    }

}
