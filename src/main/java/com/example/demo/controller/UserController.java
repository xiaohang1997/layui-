package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.until.JsonResult;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-01-13 14:51:24
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }


    @PostMapping("/login")
    public JSONObject login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        List<User> users = userService.queryAll(u);
        if (users.isEmpty()) {
            return JsonResult.sendError();
        } else {
            HttpSession session = request.getSession();
            //设置会话session对象有效期，默认10分钟
            session.setMaxInactiveInterval(10 * 60);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(10 * 60);
            response.addCookie(cookie);
            System.out.println(cookie.toString());
            session.setAttribute("username", u.getName());
            System.out.println("username=" + session.getAttribute("username"));
            return JsonResult.sendSuccess();
        }
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println((String) session.getAttribute("username"));
        return (String) session.getAttribute("username");
    }

    @RequestMapping("/logOut")
    public JSONObject logOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return JsonResult.sendSuccess();
    }

    @RequestMapping("findAll")
    public ResultVO findAll(int page, int limit){
        PageInfo pageInfo = userService.findAll(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Product> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("insert")
    public JSONObject addUser(@RequestBody User user){
        if (userService.insert(user)>0){
            return JsonResult.sendSuccess();
        }else return JsonResult.sendError();
    }

    @RequestMapping("update")
    public JSONObject updateUser(@RequestBody User user){
        if (userService.update(user)>0){
            return JsonResult.sendSuccess();
        }else return JsonResult.sendError();
    }

    @RequestMapping("deleteMany")
    public JSONObject deleteMany(@RequestParam(name = "data") List<Integer> data){
        for (Integer integer: data){
            if (userService.deleteById(integer)>0){
                return JsonResult.sendError();
            }
        }
        return JsonResult.sendSuccess();
    }

    @RequestMapping("/deleteById")
    public JSONObject deleteById(Integer id){
        if (userService.deleteById(id) > 0){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("findByName")
    public ResultVO findByName(int page, int limit,@RequestParam Map<String, String> map){
        String string = map.get("searchParams");
        String name = string.split("\"")[3];
        PageInfo pageInfo = userService.findByName(page, limit, name);
        int total = (int)pageInfo.getTotal();
        ResultVO<Product> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }


}