package com.onebooming.boecloudservice.controller;

import com.onebooming.boecloudservice.bean.RespBean;
import com.onebooming.boecloudservice.bean.VMachine;
import com.onebooming.boecloudservice.common.EmailRunnable;
import com.onebooming.boecloudservice.common.poi.PoiUtils;
import com.onebooming.boecloudservice.service.VMachineService;
import com.onebooming.boecloudservice.utils.base.Result;
import com.onebooming.boecloudservice.utils.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @author Onebooming
 */
@RestController
@RequestMapping("/admin/vmachine")
public class VMachineController {
    @Autowired
    VMachineService vMachineService;

    @Autowired
    ExecutorService executorService;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    String emailAddress;

    @PostMapping(value = "/vm")
    public Result addVMachine(VMachine vMachine) {
        if (vMachineService.addNewVMInfo(vMachine) == 1) {
            executorService.execute(new EmailRunnable(vMachine,
                    javaMailSender, templateEngine,emailAddress));
            return new Result(true, StatusCode.OK,"添加成功");
        }
        return new Result(false, StatusCode.ERROR,"添加失败");
    }

    @PutMapping(value = "/vm")
    public Result updateVMachine(VMachine vMachine){
        if(vMachineService.updateVMInfo(vMachine) == 1){
            return new Result(true, StatusCode.OK,"修改成功");
        }
        return new Result(false, StatusCode.ERROR,"修改失败");
    }

    @DeleteMapping(value = "/vm/{ids}")
    public Result deleteVMbyId(@PathVariable String ids){
        if(vMachineService.deleteVMByIds(ids)){
            return new Result(true, StatusCode.OK,"删除成功");
        }
        return new Result(false, StatusCode.ERROR,"删除失败");
    }

    @GetMapping(value = "/vm")
    public Result getVMachineByPage(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size){
        return new Result(true,StatusCode.OK,"查询成功",vMachineService.getVMachineByPageShort(page,size));
    }

    @RequestMapping(value = "/exportVM", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportEmp2Excel(vMachineService.getAll());
    }

    @RequestMapping(value = "/importVM", method = RequestMethod.POST)
    public Result importEmp(MultipartFile file) {

        List<VMachine> vMachines = PoiUtils.importEmp2List(file);
        if (vMachineService.addVMachines(vMachines) == vMachines.size()) {
            return new Result(true,StatusCode.OK,"导出成功");
        }
        return new Result(true,StatusCode.OK,"导出失败");
    }
}
