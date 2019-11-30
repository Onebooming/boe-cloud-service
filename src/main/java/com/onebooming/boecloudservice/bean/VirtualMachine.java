package com.onebooming.boecloudservice.bean;

import java.util.Date;

/**
 * 虚拟机实体类
 * @author Onebooming
 */
public class VirtualMachine {
    public Long id;//虚拟机ID
    public String machineName;//虚拟机名称
    public String vmPathName;//虚拟机路径名
    public String guestFullName;//客户机全名
    public String instanceUuid;//实例UUID
    public String annotation;//注释
    public String powerState;//电源状态
    public String toolsStatus;//工具状态
    public String ipAddress;//IP地址
    public Integer memorySizeMB;//内存大小
    public Integer numCpu;//CPU核数
    public Integer numVirtualDisks;//虚拟硬盘数
    public Date bootTime;//boot时间
    public String exsiIp;//exsiIP


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getVmPathName() {
        return vmPathName;
    }

    public void setVmPathName(String vmPathName) {
        this.vmPathName = vmPathName;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getInstanceUuid() {
        return instanceUuid;
    }

    public void setInstanceUuid(String instanceUuid) {
        this.instanceUuid = instanceUuid;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getPowerState() {
        return powerState;
    }

    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    public String getToolsStatus() {
        return toolsStatus;
    }

    public void setToolsStatus(String toolsStatus) {
        this.toolsStatus = toolsStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getMemorySizeMB() {
        return memorySizeMB;
    }

    public void setMemorySizeMB(Integer memorySizeMB) {
        this.memorySizeMB = memorySizeMB;
    }

    public Integer getNumCpu() {
        return numCpu;
    }

    public void setNumCpu(Integer numCpu) {
        this.numCpu = numCpu;
    }

    public Integer getNumVirtualDisks() {
        return numVirtualDisks;
    }

    public void setNumVirtualDisks(Integer numVirtualDisks) {
        this.numVirtualDisks = numVirtualDisks;
    }

    public Date getBootTime() {
        return bootTime;
    }

    public void setBootTime(Date bootTime) {
        this.bootTime = bootTime;
    }

    public String getExsiIp() {
        return exsiIp;
    }

    public void setExsiIp(String exsiIp) {
        this.exsiIp = exsiIp;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "id=" + id +
                ", machineName='" + machineName + '\'' +
                ", vmPathName='" + vmPathName + '\'' +
                ", guestFullName='" + guestFullName + '\'' +
                ", instanceUuid='" + instanceUuid + '\'' +
                ", annotation='" + annotation + '\'' +
                ", powerState='" + powerState + '\'' +
                ", toolsStatus='" + toolsStatus + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", memorySizeMB=" + memorySizeMB +
                ", numCpu=" + numCpu +
                ", numVirtualDisks=" + numVirtualDisks +
                ", bootTime=" + bootTime +
                ", exsiIp='" + exsiIp + '\'' +
                '}';
    }
}
