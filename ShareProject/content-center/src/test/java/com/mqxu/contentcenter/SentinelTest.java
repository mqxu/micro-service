//package com.mqxu.contentcenter;
//
//import org.springframework.web.client.RestTemplate;
//
///**
// * @ClassName SentinelTest
// * @Description TODO
// * @Author mqxu
// * @Date 2020/10/6
// **/
//public class SentinelTest {
//    public static void main(String[] args) throws InterruptedException {
//        RestTemplate restTemplate = new RestTemplate();
//        for (int i = 0; i < 100; i++) {
//            String object = restTemplate.getForObject("http://localhost:8888/byResource", String.class);
//            System.out.println(object);
////            Thread.sleep(1000);
//        }
//    }
//
////    public static void main(String[] args) {
////        RestTemplate restTemplate = new RestTemplate();
////        for (int i = 0; i < 10000; i++) {
////            String object = restTemplate.getForObject("http://localhost:8888/test-a", String.class);
////            System.out.println("-----" + object + "-----");
////        }
////    }
//}
