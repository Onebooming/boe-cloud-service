package com.onebooming.boecloudservice.dao;

import com.onebooming.boecloudservice.bean.PhysicServer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Onebooming
 * @apiNote 服务器服务访问层类
 */

@Mapper
public interface PhysicServerMapper {
    /**
     * 增加服务器信息
     * @param physicServer
     * @return
     */
    public void addServers(PhysicServer physicServer);

    /**
     * 更新服务器信息
     * @param physicServer
     * @return
     */
    public void updateServers(PhysicServer physicServer);

    /**
     * 根据id删除服务器信息
     * @param id
     */
    public void deleteServersById(Long id);

    /**
     * 获取所有服务器信息
     * @return
     */
    public List<PhysicServer> getAllServers();

    /**
     * 根据服务器名获取
     * @param name
     * @return
     */
    public PhysicServer getServerByName(@Param("name") String name);


}
