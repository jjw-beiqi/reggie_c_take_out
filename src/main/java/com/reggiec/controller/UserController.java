package com.reggiec.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.reggiec.common.R;
import com.reggiec.entity.User;
import com.reggiec.service.UserService;
import com.reggiec.utils.SMSUtils;
import com.reggiec.utils.ValidateCodeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 发送手机短信验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession){

        // 获取手机号
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)){
//            // 生成验证码
//            String code = ValidateCodeUtils.generateValidateCode(4).toString();
//
//            // 调用阿里云短信服务API
//            SMSUtils.sendMessage("瑞吉外卖", "" , phone, code);
//
//            // 将生成到验证码保存到session
//            httpSession.setAttribute(phone,code);
//
//            // 将验证码缓存到 redis 中，并设置过期时间为5分钟
//            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);


            R.success("短信发送成功！");
        }

        return R.error("短信发送失败！");


    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession){

        // 获取手机号
        String phone = map.get("phone").toString();

//        // 获取验证码
//        String code = map.get("code").toString();
//
//        // 从 session 中获取保存到验证码
//        // String codeInSession = httpSession.getAttribute(phone).toString();
//
//        // 从 redis 中获取缓存的验证码
//        String codeInRedis = redisTemplate.opsForValue().get(phone).toString();
//
//        // 比较验证码
//        if (codeInRedis != null && codeInRedis.equals(code)){
//            // 能够比对成功，说明登录成功
//
//            // 判断手机号用户是否为新用户，如果是新用户就自动注册
//            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(User::getPhone,phone);
//
//            User user = userService.getOne(queryWrapper);
//
//            if (user == null){
//                user = new User();
//                user.setPhone(phone);
//                user.setStatus(1);
//                userService.save(user);
//            }
//
//            // 如果用户登录成功，则删除 redis 中缓存的验证码
//            redisTemplate.delete(phone);

//            // 将用户id放到 session 中
//            httpSession.setAttribute("user",user.getId());
//            return R.success(user);
//        }

        // 判断手机号用户是否为新用户，如果是新用户就自动注册
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);

        User user = userService.getOne(queryWrapper);

        if (user == null){
            user = new User();
            user.setPhone(phone);
            user.setStatus(1);
            userService.save(user);
        }

        // 将用户id放到 session 中
        httpSession.setAttribute("user",user.getId());
        return R.success(user);

        // return R.error("验证码错误！");
    }
}
