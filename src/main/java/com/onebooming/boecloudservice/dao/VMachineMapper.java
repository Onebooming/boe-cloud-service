package com.onebooming.boecloudservice.dao;


import com.onebooming.boecloudservice.bean.VMIP;
import com.onebooming.boecloudservice.bean.VMachine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Onebooming
 *
 */
@Component
@Mapper
public interface VMachineMapper {
    List<VMIP> getAllVMIP();

    int addVMchine(VMachine vMachine);

    //List<VMachine> getVMachineByPage(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getCountByKeywords(@Param("keywords") String keywords);

    int updateVMachine(VMachine vMachine);

    int deleteVMachineByIds(@Param("ids") Long[] ids);

    int deleteVMachineById(@Param("id") Long id);

    int addVMachines(@Param("vMachines") List<VMachine> vMachines);

    List<VMachine> getVMachineByPageShort(@Param("start") int start, @Param("size") Integer size);

    List<VMachine> getAll();
}
