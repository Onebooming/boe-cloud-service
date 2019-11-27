package com.onebooming.boecloudservice.service;

import com.onebooming.boecloudservice.bean.PhysicServer;
import com.onebooming.boecloudservice.dao.PhysicServerMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onebooming.boecloudservice.utils.IdWorker;

import java.io.InputStream;
import java.util.List;

@Service
@Transactional
public class PhysicServerService {
    @Autowired
    PhysicServerMapper physicServerMapper;
//    public PhysicServerMapper physicServerMapper;
//    @Before
//    public void setUp() throws Exception {
//        //指定配置文件
//        String resource = "mybatis-config.xml";
//        //读取配置文件
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //构建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
//        //1.映射文件的命名空间（namespace）必须是mapper接口的全路径
//        //2.映射文件的statement的id必须和mapper接口的方法名保持一致
//        //3.Statemen的resultType必须和mapper接口方法的返回类型一致
//        //4.Statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
//        this.physicServerMapper = sqlSession.getMapper(physicServerMapper.getClass());
//    }


    private IdWorker idWorker;
    /**
     * 增加新的服务器信息记录
     * @param physicServer
     */
    public void AddNewServer(PhysicServer physicServer){
//        physicServer.setId(idWorker.nextId()+"");
        physicServerMapper.addServers(physicServer);
    }

    /**
     * 获得所有服务器列表
     * @return
     */
    public List<PhysicServer> getAllServers(){
        return physicServerMapper.getAllServers();
    }

    /**
     * 修改服务器信息
     * @param physicServer
     */
    public void update(PhysicServer physicServer){
        physicServerMapper.updateServers(physicServer);
    }

    /**
     * 根据id删除服务器信息
     * @param id
     */
    public void deleteServerById(Long id){
        physicServerMapper.deleteServersById(id);
    }
}