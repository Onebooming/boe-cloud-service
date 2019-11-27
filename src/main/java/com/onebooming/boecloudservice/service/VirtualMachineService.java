package com.onebooming.boecloudservice.service;

import com.onebooming.boecloudservice.bean.VirtualMachine;
import com.onebooming.boecloudservice.dao.VirtualMachineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Onebooming
 * @apiNote 虚拟机服务层
 */

@Service
@Transactional
public class VirtualMachineService {
    @Autowired
    private VirtualMachineDao virtualMachineDao;

    /**
     * 服务类：增加虚拟机信息
     * @param virtualMachine
     */
    public void addNewVMInfo(VirtualMachine virtualMachine){
        virtualMachineDao.addVirtualMachine(virtualMachine);
    }

    /**
     * 服务类：修改虚拟机信息
     * @param virtualMachine
     */
    public void updateVMInfo(VirtualMachine virtualMachine){
        virtualMachineDao.updateVMByName(virtualMachine);
    }

    /**
     * 服务类：根据id删除虚拟机记录
     * @param id
     */
    public void deleteVMById(Long id){
        virtualMachineDao.deleteById(id);
    }

    /**
     * 服务类：删除全部虚拟机记录
     */
    public void deleteAllVM(){
        virtualMachineDao.deleteAll();
    }

    /**
     * 服务类：查询全部服务器记录
     * @return
     */
    public List<VirtualMachine> findAll(){
        return virtualMachineDao.findAll();
    }

    /**
     * 服务类：根据虚拟机名查询虚拟机记录
     * @param name
     * @return
     */
    public List<VirtualMachine> findByName(String name){
        return virtualMachineDao.selectByName(name);
    }

    /**
     * 服务类：根据id查询服务器类
     * @param id
     * @return
     */
    public VirtualMachine findById(Long id){
        return virtualMachineDao.selectById(id);
    }
}
