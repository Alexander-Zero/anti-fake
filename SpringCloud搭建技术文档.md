# SpringCloud搭建技术文档

### 1   概况

搭建顺序: 服务注册与发现中心(Eureka) -> Admin->链路追踪(Sleuth和Zipkin)->配置中心(ConfigCenter)->具体服务(服务ABCD) 

### 2   创建空的总项目

​      ![image-20201010103840241](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010103840241.png)                 

### 3   创建Eureka Server(新建Model)

需Eureka Server, Actuator, Admin三个starter

 ![image-20201010103853889](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010103853889.png)

主启动类加@EnableEurekaServer注解

 ![image-20201010103906692](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010103906692.png)

 配置文件如下

```xml
server.port=6379

#是否注册为服务和是否拉取服务,只有一个Server时设置为false
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
 
spring.application.name=EurekaServer
eureka.instance.hostname=eureka1.com

#高可用配置,相互注册
eureka.client.service-url.defaultZone=http://eureka2.com:6380/eureka/,http://eureka3.com:6381/eureka/

#自我保护关闭
#eureka.server.enable-self-preservation=false

#Security配置
#spring.security.user.name=alex
#spring.security.user.password=123456

#链路追踪
#spring.zipkin.base-url=http://localhost:9411/
#spring.sleuth.sampler.rate=1

#admin监控配置
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
spring.boot.admin.client.url=http://localhost:2048/
```

 

### 4   创建Admin(新建Model)

需admin Server , admin ui ,(邮件通知需mail).

 ![image-20201010104617423](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010104617423.png)

勾选后需再添加以下starter

```java
		<!--邮件通知-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

		<!--Admin UI-->
		<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-server-ui</artifactId>
		</dependency>
```

 

主类添加@EnableAdminServer注解

 ![image-20201010104632580](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010104632580.png)



以下为配置微信,邮件或钉钉通知(暂无)

 

 

### 5   创建配置中心 (新建Model)

需Config server, eureka client, admin, actuator

 ![image-20201010104644652](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010104644652.png)

主类添加@EnableConfigServer

 ![image-20201010104650808](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010104650808.png)

需在配置类中写明以下

```
server.port=7777

#服务名
spring.application.name=ConfigCenter
#拉取服务的地址
eureka.client.service-url.defaultZone=http://eureka1.com:6379/eureka/,http://eureka2.com:6380/eureka/,http://eureka3.com:6381/eureka/

#git地址
spring.cloud.config.server.git.uri=https://github.com/Alexander-Zero/SpringCloud-ConfigCenter.git
#分支
spring.cloud.config.label=master

```



### 6   创建网关(新建Model)

需Admin client, Eureka client, zipkin , sleuth, zuul ,actuator

 ![image-20201010104754930](C:\Users\cms19\AppData\Roaming\Typora\typora-user-images\image-20201010104754930.png)

网关配置如下:

```
server.port=1024

spring.application.name=Zuul
eureka.client.service-url.defaultZone=http://eureka1.com:6379/eureka/,http://eureka2.com:6380/eureka/,http://eureka3.com:6381/eureka/

#配置服务负载均衡策略
#feignconsumer.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule

#不走网关的服务
#zuul.ignored-services=provider

#前缀
#zuul.prefix=/api/v1
#zuul.strip-prefix=false

#配置服务的网关
#注意 /和 /** 都要填写
zuul.routes.serviceA=/alex/**

#链路追踪配置
spring.zipkin.base-url=http://localhost:9411/
spring.sleuth.sampler.rate=1

#健康监控
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
spring.boot.admin.client.url=http://localhost:2048/
```



### 7   创建链路追踪(新建Model)

下载Zipkin Jar包并启动

 

 

 

 

### 8  新建服务模块(A服务)

 

 