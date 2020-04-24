package com.spark.mybatis.factory;

import com.spark.mybatis.mapper.TbLogsMapper;
import com.spark.mybatis.model.TbLogs;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MBFactory {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        TbLogsMapper logsMapper = sqlSessionFactory.openSession()
                .getMapper(TbLogsMapper.class);

        List<TbLogs> logs = logsMapper.selectAll();

        for (TbLogs log : logs) {
            System.out.println(log);
        }

    }
}
