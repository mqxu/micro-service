# 基于微服务架构的知识分享小程序



## 一、组成

1. content-center：内容中心微服务
2. user-center：用户中心微服务
3. share-wxapp：客户端

## 二、技术选型

1. 后端
   - 服务注册与发现：Spring Cloud Alibaba Nacos
   - 负载均衡：Spring Cloud Ribbon
   - 服务容错、限流、降级：Spring Cloud Alibaba Sentinel
   - 服务调用：Spring Cloud OpenFeign
   - 异步消息队列：Apache RocketMQ
   - 服务网关：Spring Cloud Gateway
   - 服务调用链监控：Spring Cloud Zipkin & Slueth
   - 认证和鉴权：JWT & Spring AOP
   - 数据库持久层：tk mybatis
   - 服务器操作系统：CentOS 7
   - 服务器数据库：MySql 8
2. 客户端
   - 基于Vue.js的跨端开发框架uni-app
3. 其他
   - Swagger接口文档生成

## 三、效果图

1. 登录和未登录（微信账号授权登录）

   <img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163236.png" alt="image-20201018161124263" style="zoom: 50%; margin-left: 0px;" />

   

   <img src="https://i.loli.net/2020/10/18/LdeGq7FsyjW1DQn.png" alt="image-20201018161309515" style="zoom:50%;margin-left:0;" />

   

   

   

2. 首页

   - 根据用户是否拥有该资源显示“兑换”和“下载”不同链接
   - 根据资源是原创还是转载显示不同角标
   - 可以实现上拉加载分页和下拉刷新
   - 网络请求的loading

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163647.png" alt="image-20201018163647088" style="zoom:50%;margin-left:0;" />

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163718.png" alt="image-20201018163718427" style="zoom:50%;margin-left:0;" />

3.下载

显示资源详情，点击“复制”按钮可以将下载地址复制到系统剪贴板

<img src="https://i.loli.net/2020/10/18/ZRxw8AXPnYbyENF.png" alt="image-20201018161621142" style="zoom:50%;margin-left:0;" />

4.兑换

如果积分够的话，可以兑换成功，兑换后个人积分会扣除相应分值，跳回首页，该资源将变为可以下载

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163257.png" alt="image-20201018161722839" style="zoom:50%;margin-left:0;" />

5.投稿

如图所示，投稿成功后，通过管理员审核，可以获得相应积分

<img src="https://i.loli.net/2020/10/18/gzFDLqe7THBoRrX.png" style="zoom:50%;margin-left:0;" />

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163311.png" alt="image-20201018162107768" style="zoom:50%;margin-left:0;" />

6.个人中心

我的兑换

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163323.png" alt="image-20201018162553689" style="zoom:50%;margin-left:0;" />

积分明细

<img src="https://i.loli.net/2020/10/18/MIbmPaKlvQFqecC.png" alt="image-20201018162616048" style="zoom:50%;margin-left:0;" />

我的投稿，可以显示不同的投稿状态，已经审核通过的可以获得积分并且可以点击下载

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018163336.png" alt="image-20201018162709990" style="zoom:50%;margin-left:0;" />

7.管理员

可以审核投稿，选择通过或不通过（说明理由），发布或暂不发布



<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018164204.png" alt="image-20201018164138620" style="zoom:44%;margin-left:0;" />

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018164552.PNG" alt="IMG_7187" style="zoom: 44%;margin-left:0; " />

<img src="https://pic-go-test.oss-cn-hangzhou.aliyuncs.com/md/20201018164347.PNG" alt="IMG_7188" style="zoom: 44%; margin-left:0;" />







