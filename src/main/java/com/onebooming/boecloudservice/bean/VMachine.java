package com.onebooming.boecloudservice.bean;

import java.util.Date;

/**
 * 虚拟机实体类2.0+更详细的信息
 */
public class VMachine {
    private Long id;//唯一id
    private String name;//虚拟机名
    private String ip;//业务ip
    private Date createDate;//创建时间
    private String uuid;//uuid
    private Integer cpu;//CPU核数
    private Integer memory;//分配内存
    private Integer storage;//分配存储容量
    private String networkAdapter;//网络适配器
    private String ownner;//虚拟机用户
    private String email;//用户邮箱
    private Long phoneNum;//用户电话号码
    private String department;//用户部门
    private String job;//用户岗位
    private String duty;//用户工作职责
    private Double fee;//使用费用
    private String useForm;//租赁形式
    private Float cpuDosage;//cpu用量
    private Float memoryDosage;//内存用量
    private Float storageDosage;//存储用量
    private Date beginWorkDate;//开始工作时间
    private String workState;//工作状态
    private String supervisor;//超级管理员
    private String osVersion;//操作系统版本
    private Date beFormDate;//修改时间
    private Date notWorkDate;//故障时间
    private String serverHostIp;//服务器物理主机IP
    private String notice;//备注
    private Double runDuration;//运行总时长


    public VMachine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getNetworkAdapter() {
        return networkAdapter;
    }

    public void setNetworkAdapter(String networkAdapter) {
        this.networkAdapter = networkAdapter;
    }

    public String getOwnner() {
        return ownner;
    }

    public void setOwnner(String ownner) {
        this.ownner = ownner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getUseForm() {
        return useForm;
    }

    public void setUseForm(String useForm) {
        this.useForm = useForm;
    }

    public Float getCpuDosage() {
        return cpuDosage;
    }

    public void setCpuDosage(Float cpuDosage) {
        this.cpuDosage = cpuDosage;
    }

    public Float getMemoryDosage() {
        return memoryDosage;
    }

    public void setMemoryDosage(Float memoryDosage) {
        this.memoryDosage = memoryDosage;
    }

    public Float getStorageDosage() {
        return storageDosage;
    }

    public void setStorageDosage(Float storageDosage) {
        this.storageDosage = storageDosage;
    }

    public Date getBeginWorkDate() {
        return beginWorkDate;
    }

    public void setBeginWorkDate(Date beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Date getBeFormDate() {
        return beFormDate;
    }

    public void setBeFormDate(Date beFormDate) {
        this.beFormDate = beFormDate;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public String getServerHostIp() {
        return serverHostIp;
    }

    public void setServerHostIp(String serverHostIp) {
        this.serverHostIp = serverHostIp;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Double getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(Double runDuration) {
        this.runDuration = runDuration;
    }

    public VMachine(Long id, String name, String ip, Date createDate, String uuid, Integer cpu, Integer memory, Integer storage, String networkAdapter, String ownner, String email, Long phoneNum, String department, String job, String duty, Double fee, String useForm, Float cpuDosage, Float memoryDosage, Float storageDosage, Date beginWorkDate, String workState, String supervisor, String osVersion, Date beFormDate, Date notWorkDate, String serverHostIp, String notice, Double runDuration) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.createDate = createDate;
        this.uuid = uuid;
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.networkAdapter = networkAdapter;
        this.ownner = ownner;
        this.email = email;
        this.phoneNum = phoneNum;
        this.department = department;
        this.job = job;
        this.duty = duty;
        this.fee = fee;
        this.useForm = useForm;
        this.cpuDosage = cpuDosage;
        this.memoryDosage = memoryDosage;
        this.storageDosage = storageDosage;
        this.beginWorkDate = beginWorkDate;
        this.workState = workState;
        this.supervisor = supervisor;
        this.osVersion = osVersion;
        this.beFormDate = beFormDate;
        this.notWorkDate = notWorkDate;
        this.serverHostIp = serverHostIp;
        this.notice = notice;
        this.runDuration = runDuration;
    }

    @Override
    public String toString() {
        return "VMachine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", createDate=" + createDate +
                ", uuid='" + uuid + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", storage=" + storage +
                ", networkAdapter='" + networkAdapter + '\'' +
                ", ownner='" + ownner + '\'' +
                ", Email='" + email + '\'' +
                ", phoneNum=" + phoneNum +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                ", duty='" + duty + '\'' +
                ", fee=" + fee +
                ", useForm='" + useForm + '\'' +
                ", cpuDosage=" + cpuDosage +
                ", memoryDosage=" + memoryDosage +
                ", storageDosage=" + storageDosage +
                ", beginWorkDate=" + beginWorkDate +
                ", workState='" + workState + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", beFormDate=" + beFormDate +
                ", notWorkDate=" + notWorkDate +
                ", serverHostIp='" + serverHostIp + '\'' +
                ", notice='" + notice + '\'' +
                ", runDuration=" + runDuration +
                '}';
    }
}
