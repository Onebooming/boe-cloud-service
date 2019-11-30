package com.onebooming.boecloudservice.dao;

import com.onebooming.boecloudservice.bean.VMachine;
import com.onebooming.boecloudservice.common.poi.PoiUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VMachineMapperTest {
    @Autowired
    private VMachineMapper vMachineMapper;

    @Test
    public void add(){
        VMachine vMachine = new VMachine();
        vMachine.setName("en");
        vMachineMapper.addVMchine(vMachine);
    }

    @Test
    public void addList(){
        ArrayList<VMachine> vMachines = new ArrayList<VMachine>();
        VMachine vMachine1 = new VMachine();
        vMachine1.setName("boe vritual 1 ");
        vMachines.add(vMachine1);
        VMachine vMachine2 = new VMachine();
        vMachine2.setName("boe vritual 2 ");
        vMachines.add(vMachine2);
        vMachineMapper.addVMachines(vMachines);

    }

    @Test
    public void show(){
        List<VMachine> vMachineList = new ArrayList<VMachine>();
        vMachineList = vMachineMapper.getVMachineByPageShort(1,2);
        for(VMachine vMachine :vMachineList){
            System.out.println(vMachine);
        }
    }

    @Test
    public void update(){
        VMachine vMachine = new VMachine();
        vMachine.setName("cloud compute");
        vMachine.setIp("10.251.126.22");
        vMachine.setId(1L);
        vMachineMapper.updateVMachine(vMachine);
    }
    @Test
    public void deleteByIds(){
        Long[] ids = {4L,5L};
        vMachineMapper.deleteVMachineByIds(ids);
    }

    @Test
    public void excelImport() throws Exception {
        String path = "D:\\06 OperationLib\\A_IDEA\\boe-cloud-service\\VirtualMachineList-v.xls";
        // 读取Excel文件
        File file = new File(path);
        List<VMachine> vMachineList = new ArrayList<VMachine>();


        vMachineList = PoiUtils.importVMachineList(file);
        int i = 0;
        for(VMachine vMachine : vMachineList){
            System.out.println(i++);
            System.out.println(vMachine);
            System.out.println();
        }
        vMachineMapper.addVMachines(vMachineList);
    }
}
