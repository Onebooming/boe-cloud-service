package com.onebooming.boecloudservice;

import com.onebooming.boecloudservice.bean.PhysicServer;
import com.onebooming.boecloudservice.bean.VirtualMachine;
import com.onebooming.boecloudservice.dao.VirtualMachineDao;
import com.onebooming.boecloudservice.service.PhysicServerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BoeCloudServiceApplicationTests {

    @Autowired
    PhysicServerService physicServerService;

    @Autowired
    VirtualMachineDao virtualMachineDao;

    @Test
    void virtualMachineDaoTest(){
        VirtualMachine virtualMachine = new VirtualMachine();
        virtualMachine.setMachineName("111111");
        virtualMachine.setVmPathName("1111111");
        virtualMachine.setGuestFullName("1111111");
        virtualMachine.setInstanceUuid("1111111");
        virtualMachineDao.addVirtualMachine(virtualMachine);

        virtualMachine.setId(2L);
        virtualMachine.setMachineName("222222");
        virtualMachine.setVmPathName("2222222");
        virtualMachine.setGuestFullName("22222222");
        virtualMachine.setInstanceUuid("222222222");
        virtualMachineDao.addVirtualMachine(virtualMachine);

        virtualMachineDao.deleteById(2L);

        virtualMachine.setId(1L);
        virtualMachine.setMachineName("4444444");
        virtualMachine.setVmPathName("44444444");
        virtualMachine.setGuestFullName("44444444");
        virtualMachine.setInstanceUuid("4444444444");
        virtualMachineDao.updateVMById(virtualMachine);

        virtualMachine.setMachineName("4444444");
        virtualMachine.setVmPathName("000000");
        virtualMachine.setGuestFullName("0000000");
        virtualMachine.setInstanceUuid("0000000000");
        virtualMachineDao.updateVMByName(virtualMachine);

        ArrayList<VirtualMachine> arrayList = new ArrayList<VirtualMachine>();
        arrayList = (ArrayList<VirtualMachine>) virtualMachineDao.selectByName("4444444");
        for(VirtualMachine virtualMachine1: arrayList){
            System.out.println(virtualMachine);
        }
    }

    @Test
    void contextLoads() {
        PhysicServer physicServer = new PhysicServer();
        physicServer.setName("ldldlld");
        physicServer.setArea("beijing");
        physicServer.setbIp("10.222.3.4");

        physicServerService.AddNewServer(physicServer);
        List<PhysicServer> list = physicServerService.getAllServers();
        for(PhysicServer physicServer1 : list){
            System.out.println(physicServer1);
        }
        physicServer.setId(1L);
        physicServer.setbIp("2233334");
        physicServer.setName("yyyyyyyyy");
        physicServer.setBrand("H3C");
        physicServer.setCpuName("Xone 5700");
        physicServerService.update(physicServer);
        physicServerService.AddNewServer(physicServer);

        physicServerService.deleteServerById(5L);
        physicServerService.deleteServerById(6L);
        physicServerService.deleteServerById(7L);

    }

}
