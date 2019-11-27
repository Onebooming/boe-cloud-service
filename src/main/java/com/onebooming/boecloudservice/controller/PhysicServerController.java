package com.onebooming.boecloudservice.controller;


import com.onebooming.boecloudservice.bean.PhysicServer;
import com.onebooming.boecloudservice.service.PhysicServerService;
import com.onebooming.boecloudservice.utils.base.Result;
import com.onebooming.boecloudservice.utils.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务器controller
 * @author Onebooming
 */
@RestController
@RequestMapping("/admin/physicserver")
public class PhysicServerController {
    @Autowired
    PhysicServerService physicServerService;

    @PostMapping("/add")
    public Result addNewServer(@RequestBody PhysicServer physicServer){
        physicServerService.AddNewServer(physicServer);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    @GetMapping("/get")
    public Result getAllServers(){
        return new Result(true,StatusCode.OK,"查询成功",physicServerService.getAllServers());
    }

    /**
     * 更新操作
     * @param physicServer
     * @param id
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody PhysicServer physicServer, @PathVariable String id){
        //physicServer.setId(id);
        physicServerService.update(physicServer);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 根据id删除服务器信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result deleteServerById(@PathVariable Long id){
        physicServerService.deleteServerById(id);
        return new Result(true,StatusCode.OK, "删除成功");
    }
}
