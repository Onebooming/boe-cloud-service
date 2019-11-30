package com.onebooming.boecloudservice.service;

import com.onebooming.boecloudservice.bean.VMachine;
import com.onebooming.boecloudservice.bean.VirtualMachine;
import com.onebooming.boecloudservice.dao.VMachineMapper;
import com.onebooming.boecloudservice.dao.VirtualMachineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Onebooming
 * @apiNote 虚拟机服务层
 */

@Service
@Transactional
public class VMachineService {
    @Autowired
    private VMachineMapper vMachineMapper;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    /**
     * 服务类：增加虚拟机信息
     *
     * @param vMachine
     */
    public int addNewVMInfo(VMachine vMachine) {
        return vMachineMapper.addVMchine(vMachine);
    }

    /**
     * 服务类：修改虚拟机信息
     *
     * @param vMachine
     */
    public int updateVMInfo(VMachine vMachine) {
        return vMachineMapper.updateVMachine(vMachine);
    }

    /**
     * 服务类：根据id删除虚拟机记录
     *
     * @param ids
     */
    public boolean deleteVMByIds(String ids) {
        String[] stringsId = ids.split(",");
        Long[] idNums = new Long[stringsId.length];
        int i = 0;
        for (String s : stringsId) {
            idNums[i] = Long.valueOf(s);
        }
        return vMachineMapper.deleteVMachineByIds(idNums) == idNums.length;
    }


    /**
     * 批量添加
     *
     * @param vMachines
     * @return
     */
    public int addVMachines(List<VMachine> vMachines) {
        return vMachineMapper.addVMachines(vMachines);
    }

    /**
     * 获取VMachine对象列表+分页
     *
     * @param page
     * @param size
     * @return
     */
    public List<VMachine> getVMachineByPageShort(Integer page, Integer size) {
        int start = (page - 1) * size;
        return vMachineMapper.getVMachineByPageShort(start, size);
    }


    public List<VMachine> getAll() {
        return vMachineMapper.getAll();
    }
}
