package com.onebooming.boecloudservice.bean;

import java.util.Objects;

public class VMIP {
    private Long id;
    private String vmIp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VMIP)) return false;
        VMIP vmip = (VMIP) o;
        return id.equals(vmip.id) &&
                vmIp.equals(vmip.vmIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vmIp);
    }

    public VMIP(String vmIp) {
        this.vmIp = vmIp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVmIp() {
        return vmIp;
    }

    public void setVmIp(String vmIp) {
        this.vmIp = vmIp;
    }
}
