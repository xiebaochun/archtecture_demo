readme
current auth:
    spring-boot-jwt
    
Architecture:
    注冊中心： consul、zookeeper、Etcd、Eureka
    健康检查：Consul spring boot的Actuator
    服务路由：Ribbon
    服务容错：Hystrix
    日志系统：logback
    
    

