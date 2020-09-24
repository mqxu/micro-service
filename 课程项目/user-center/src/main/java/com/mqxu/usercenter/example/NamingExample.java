//package com.mqxu.usercenter.example;
//
//import java.util.Properties;
//
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingFactory;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.listener.Event;
//import com.alibaba.nacos.api.naming.listener.EventListener;
//import com.alibaba.nacos.api.naming.listener.NamingEvent;
//
///**
// * @author mqxu
// */
//public class NamingExample {
//    public static void main(String[] args) throws NacosException{
//        Properties properties = new Properties();
//        properties.setProperty("serverAddr", System.getProperty("serverAddr"));
//        properties.setProperty("namespace", System.getProperty("namespace"));
//
//        NamingService naming = NamingFactory.createNamingService(properties);
//
//        naming.registerInstance("content-center", "127.0.0.1", 8081, "TEST1");
//
//        naming.registerInstance("content-center", "127.0.0.1", 9999, "DEFAULT");
//
//        System.out.println(naming.getAllInstances("content-center"));
//
//        naming.deregisterInstance("content-center", "2.2.2.2", 9999, "DEFAULT");
//
//        System.out.println(naming.getAllInstances("content-center"));
//
//        naming.subscribe("content-center", event -> {
//            System.out.println(((NamingEvent)event).getServiceName());
//            System.out.println(((NamingEvent)event).getInstances());
//        });
//    }
//}
