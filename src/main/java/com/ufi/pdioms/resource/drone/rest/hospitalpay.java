package com.ufi.pdioms.resource.drone.rest;

import com.ufi.pdioms.resource.drone.model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class hospitalpay {
    private final static Logger logger = Logger.getLogger(hospitalpay.class);//给类初始化日志对象

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/room")
    public String room() throws Exception {

        redisTemplate.opsForValue().set("room","我是哈哈哈",10, TimeUnit.SECONDS);
        String root = (String) redisTemplate.opsForValue().get("room");
        System.out.println(root);
        return root;
    }

    @GetMapping("/pass")
    public String pass() throws Exception {

        redisTemplate.opsForValue().set("pass","name:张三");
        String root = (String) redisTemplate.opsForValue().get("pass");
        JSONObject object= JSONObject.fromObject(root);
        String s = object.get("name").toString();

        System.out.println(s);
        return s;
    }
    @GetMapping("/root")
    public String hahaha(){

        String root = (String) redisTemplate.opsForValue().get("root");
        System.out.println(root);

        return root;
    }

    @GetMapping("/hahaha")
    public String kakakak(){
/**
 * 你们这
 */
        //定义两种不同格式的字符串
        String objectStr="{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
        String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
        //1、使用JSONObject
        JSONObject jsonObject=JSONObject.fromObject(objectStr);
        Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
        //2、使用JSONArray
        JSONArray jsonArray=JSONArray.fromObject(arrayStr);
        //获得jsonArray的第一个元素
        Object o=jsonArray.get(0);
        JSONObject jsonObject2=JSONObject.fromObject(o);
        Student stu2=(Student)JSONObject.toBean(jsonObject2, Student.class);/********-----****/
        System.out.println("stu:"+stu);
        System.out.println("stu2:"+stu2);
        System.out.println("stu2:"+stu2.getAge());
        return "成功输出！！";
    }
}