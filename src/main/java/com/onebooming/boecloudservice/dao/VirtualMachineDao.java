package com.onebooming.boecloudservice.dao;

import com.onebooming.boecloudservice.bean.VirtualMachine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VirtualMachineDao {
    /**
     * 增加记录
     * @param virtualMachine
     */
    /**
     * 使用Option来对应着XML设置的select标签的属性
     * userGeneratordKeys表示要使用自增主键
     * keyProperty用来指定主键字段的字段名。
     * 自增主键会使用数据库底层的自增特性。
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_virtualmachine " +
            "(machineName,vmPathName,guestFullName,instanceUuid,annotation,powerState,toolsStatus,ipAddress,memorySizeMB,numCpu,numVirtualDisks,bootTime,exsiIp) " +
            "values (" +
            "#{machineName},#{vmPathName},#{guestFullName},#{instanceUuid},#{annotation},#{powerState},#{toolsStatus},#{ipAddress},#{memorySizeMB},#{numCpu},#{numVirtualDisks},#{bootTime},#{exsiIp})")
    public void addVirtualMachine(VirtualMachine virtualMachine);

    /**
     * 删除记录
     * @param id
     */
    @Delete("delete from t_virtualmachine where id=#{id}")
    public void deleteById(@Param("id") Long id);

    @Delete("delete * from t_virtualmachine")
    public void deleteAll();

    //注意SQL语句：set后和where前都需要数据一个空格
    /**
     * 更新记录--根据id
     * @param virtualMachine
     */
    @Update("update t_virtualmachine set  " +
            "machineName=#{machineName}," +
            "vmPathName=#{vmPathName}," +
            "guestFullName=#{guestFullName}," +
            "instanceUuid=#{instanceUuid}," +
            "annotation=#{annotation}," +
            "powerState=#{powerState}," +
            "toolsStatus=#{toolsStatus}," +
            "ipAddress=#{ipAddress}," +
            "memorySizeMB=#{memorySizeMB}," +
            "numCpu=#{numCpu}," +
            "numVirtualDisks=#{numVirtualDisks}," +
            "bootTime=#{bootTime}," +
            "exsiIp=#{exsiIp} " +
            "where id=#{id}")
    public void updateVMById(VirtualMachine virtualMachine);

    /**
     * 更新记录--根据机器名--MachineName
     * @param virtualMachine
     */
    @Update("update t_virtualmachine set  " +
            "vmPathName=#{vmPathName}," +
            "guestFullName=#{guestFullName}," +
            "instanceUuid=#{instanceUuid}," +
            "annotation=#{annotation}," +
            "powerState=#{powerState}," +
            "toolsStatus=#{toolsStatus}," +
            "ipAddress=#{ipAddress}," +
            "memorySizeMB=#{memorySizeMB}," +
            "numCpu=#{numCpu}," +
            "numVirtualDisks=#{numVirtualDisks}," +
            "bootTime=#{bootTime}," +
            "exsiIp=#{exsiIp} " +
            "where machineName=#{machineName}")
    public void updateVMByName(VirtualMachine virtualMachine);

    /**
     * 查询记录---根据机器名查询
     */
    /**
     * 对于表的字段名和对象的属性名没有太大相同点并且表中的字段挺多的情况下，应该使用ResultMap做适配。
     */
    @Results(id = "VMResult", value = {
         @Result(id = true,column = "id",property = "id"),
         @Result(column = "machineName",property = "machineName"),
            @Result(column = "vmPathName",property = "vmPathName"),
            @Result(column = "guestFullName",property = "guestFullName"),
            @Result(column = "instanceUuid",property = "instanceUuid"),
            @Result(column = "annotation",property = "annotation"),
            @Result(column = "powerState",property = "powerState"),
            @Result(column = "toolsStatus",property = "toolsStatus"),
            @Result(column = "ipAddress",property = "ipAddress"),
            @Result(column = "memorySizeMB",property = "memorySizeMB"),
            @Result(column = "numCpu",property = "numCpu"),
            @Result(column = "numVirtualDisks",property = "numVirtualDisks"),
            @Result(column = "bootTime",property = "bootTime"),
            @Result(column = "exsiIp",property = "exsiIp"),
    })
    @Select("select * from t_virtualmachine where machineName = #{machineName}")
    public List<VirtualMachine> selectByName(@Param("machineName") String machineName);

    /**
     * 查询记录，获取所有虚拟机记录
     * @return
     */
    @ResultMap("VMResult")
    @Select("select * from t_virtualmachine")
    public List<VirtualMachine> findAll();

    /**
     * 根据id查询记录
     * @param id
     * @return
     */
    @Select("select * from t_virtualmachine where id = #{id}")
    public VirtualMachine selectById(@Param("id") Long id);

}
