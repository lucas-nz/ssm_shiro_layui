package com.zhousz.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ����spring��Junit����,Junit����ʱ����springIOC���� spring-test,junit
 * @author ZhouSZ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//����Junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

}
