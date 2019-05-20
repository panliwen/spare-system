package com.ufi.pdioms.resource.drone.rest;

import com.ufi.pdioms.resource.common.model.GeneralResult;
import com.ufi.pdioms.resource.drone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {

    @Autowired
    private UserService userService ;

    /**测试获取所有User用户信息**/
    @GetMapping("/getUserAll")
    public GeneralResult getTestUser()
    {
        GeneralResult result =  new GeneralResult();
        result.setResultData(userService.getUserAll());
        return result;
    }


    /**测试获取所有User用户信息==进行分页查询**/
    @GetMapping("/getUserAllPage")
    public GeneralResult getUserAllPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNo,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize)
    {
        GeneralResult result =  new GeneralResult();
        result.setResultData(userService.getUserAllPage(pageNo,pageSize));
        return result;
    }



}
