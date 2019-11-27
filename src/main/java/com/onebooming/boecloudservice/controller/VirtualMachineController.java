package com.onebooming.boecloudservice.controller;

import com.onebooming.boecloudservice.bean.VirtualMachine;
import com.onebooming.boecloudservice.service.VirtualMachineService;
import com.onebooming.boecloudservice.utils.base.Result;
import com.onebooming.boecloudservice.utils.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 虚拟机controller
 * @author Onebooming
 */

@RestController
@RequestMapping("/admin/vm")
public class VirtualMachineController {
    @Autowired
    private VirtualMachineService virtualMachineService;

    /**
     * 新增虚拟机信息
     * @param virtualMachine
     * @return
     */
    @PostMapping("/add")
    public Result addNewVM(@RequestBody VirtualMachine virtualMachine){
        virtualMachineService.addNewVMInfo(virtualMachine);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    /**
     * 查询全部虚拟机信息
     * @return
     */
    @GetMapping("/all")
    public Result getAllVM(){
        return new Result(true,StatusCode.OK,"查询成功",virtualMachineService.findAll());
    }
}
