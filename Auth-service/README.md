[![Build Status](https://travis-ci.org/keets2012/Auth-service.svg?branch=master)](https://travis-ci.org/keets2012/Auth-service)
[![codebeat badge](https://codebeat.co/badges/4594f615-67af-46b0-9adf-b69b476dc250)](https://codebeat.co/projects/github-com-keets2012-auth-service-master)
![](https://img.shields.io/badge/license-MIT-000000.svg)

## change logs

- 2018.9.1    

	版本升到`2.0-SNAPSHOT`，欲使用`sb1.5.x`版本，请切换到TAG `1.0-RELEASE`。by [CANGWU](https://github.com/CANGWU)

  Spring Cloud Security 升级到`Finchley.RELEASE`，Spring Boot由1.5.X升级到2.0.X。

    ```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.RELEASE</version>
       </dependency>
    ```

    ```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.0.RELEASE</version>
    </parent>
    ```

## quick start
本次对项目结构进行了更新，token的存储机制基于redis，当然存储方式可以自由切换，Spring Security提供了SPI的多种实现。

客户端的信息还是基于jdbc实现，所以需要导入项目中提供的表`oauth_client_details` 。

推荐首先阅读专栏文章：[认证鉴权与API权限控制在微服务架构中的设计与实现](http://blueskykong.com/categories/Security/)

**单独的整合项目地址为：   
GitHub：https://github.com/keets2012/microservice-integration   
或者 码云：https://gitee.com/keets/microservice-integration**

### maintainer
- keets2012
- CANGWU

### password模式
项目克隆之后：

1. ~~安装一下，`mvn clean install`~~
2. 修改Auth项目中的配置文件，写了`XXXX`的地方，替换成自己的实际地址（redis和mysql）
3. 数据库导入，sql脚本在项目中。创建auth数据库，运行auth.sql
4. `mvn clean spring-boot:run`
5. 其他细节参考博客
6. **你的star是对我最好的鼓励^_^**

client_secret:
$e0801$65x9sjjnRPuKmqaFn3mICtPYnSWrjE7OB/pKzKTAI4ryhmVoa04cus+9sJcSAFKXZaJ8lcPO1I9H22TZk6EN4A==$o+ZWccaWXSA2t7TxE5VBRvz2W8psujU3RPPvejvNs4U=
client_id:
frontend

进行请求获取Token授权：
![head](http://image.blueskykong.com/login1-header1.png "头部信息")
![form](http://image.blueskykong.com/loginform3.png "表单信息")


笔者自己运行了结果如下：

```yaml
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDkwNzMzMjcsIlgtQU9ITy1Vc2VySWQiOiIxNGY1MmE0OS0yYTgxLTRhMmYtOGI5Mi01ZmU0NzUzZGRmZGEiLCJ1c2VyX25hbWUiOiIxODM2MjkxNjcyNiIsImp0aSI6IjM5NDEzN2I5LTNjZGItNGUyNy04NGRjLWM5YjEyYzk3ZTA4YyIsImNsaWVudF9pZCI6ImZyb250ZW5kIiwic2NvcGUiOlsiYWxsIl19.pGZhGNVECg0b4LB_pYXTTVKjNn8FA5biM04Bhcd-MEE",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxODM2MjkxNjcyNiIsInNjb3BlIjpbImFsbCJdLCJhdGkiOiIzOTQxMzdiOS0zY2RiLTRlMjctODRkYy1jOWIxMmM5N2UwOGMiLCJleHAiOjE1MTE2MjIxMjcsIlgtQU9ITy1Vc2VySWQiOiIxNGY1MmE0OS0yYTgxLTRhMmYtOGI5Mi01ZmU0NzUzZGRmZGEiLCJqdGkiOiJkYTBmOTMxMS1lZjc0LTRiMjQtODViZi04ZTNjNDVhNGEyNzkiLCJjbGllbnRfaWQiOiJmcm9udGVuZCJ9.2MRdqEogAwbesRfj2TKoWhMazItBlpjbQx7dlgfFpHE",
    "expires_in": 43199,
    "scope": "all",
    "X-AOHO-UserId": "14f52a49-2a81-4a2f-8b92-5fe4753ddfda",
    "jti": "394137b9-3cdb-4e27-84dc-c9b12c97e08c",
    "X-AOHO-ClientId": "frontend"
}
```

ps: 登录的用户名密码要在表单里面写，内容随意，因为在代码中已经去掉了对user服务的校验。

### 授权码模式
本次更新添加了对授权码模式的使用

授权码模式需要用户登录，所以借助浏览器

首先给数据库表中的`oauth_client_details`表中`client_id`为`frontend`的行`authorized_grant_types`添加`authorization_code`，`web_server_redirect_uri`设置为`http://localhost:8080`。表示该客户端允许授权码模式以及授权码回调地址为http://localhost:8080

浏览器访问地址

```yaml
http://localhost:9000/oauth/authorize?response_type=code&client_id=frontend&
scope=all&redirect_uri=http://localhost:8080
```


进入登录授权页面并同意授权，从回调地址中获取授权码

```yaml
http://localhost:8080/?code=xGjrTm
```

通过授权码获取access_token

```yaml
method: post
url: http://localhost:9000/oauth/token?grant_type=authorization_code
header:
{
  Authorization: Basic ZnJvbnRlbmQ6ZnJvbnRlbmQ=,
  Content-Type: application/x-www-form-urlencoded
}
body:
{
  code: xGjrTm,
  redirect_uri: http://localhost:8080
}
```

### 写在最后

项目整合如果遇到问题，可以加入qq群(649932629)交流。

![](http://image.blueskykong.com/qq-chat1.JPG)

ps: qq交流群已设置付费，可以过滤很多广告，营造高质量的技术交流群。

*有问题联系 aoho002#gmail.com*

### MIT License

Copyright (c) 2018 aoho
