package com.NGEmobi.dao;

import com.NGEmobi.model.Content;
import com.NGEmobi.model.Strategy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class CommonDao {
    SqlSession session = null;

    public CommonDao() {
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //构建sqlSession的工厂

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
         session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
    }

    public Content selectContent(String appName){
        Content content =session.selectOne("ContentMapper.selectByAppName",appName);
        return content;
    }

    public Strategy selectStrategy(Integer status){
        Strategy strategy = session.selectOne("StrategyMapper.selectByStatus",status);
        return strategy;

    }

    public Boolean updateContent(Content Content){
        int affectRow =session.update("ContentMapper.updateByAppName",Content);
        System.out.println(affectRow);
        if(affectRow != 0 && affectRow != -1)
            return true;
        else
            return false;
    }

    public void sessionClose() {
        session.commit();
        session.close();
    }


}
