### 1. 配置信息使用git管理注意事项
1. 通过http协议,配置信息如下    
```
spring:
  cloud:
    config:
      server:
        git:
          username: root
          password: 123456
          http://172.18.115.136/group1/project1.git
```
2. 通过ssh协议（推荐）
* 生成密钥
* git服务器端添加公钥
* 本地添加文件 .ssh/config
```
Host 172.18.115.136
    User root
    IdentityFile ~/.ssh/id_rsa
    HashKnownHosts no
    HostKeyAlgorithms ssh-rsa,ssh-dss
Host github.com
    User 1313475@qq.com
    IdentityFile ~/.ssh/id_rsa
    HashKnownHosts no
    HostKeyAlgorithms ssh-rsa,ssh-dss
``` 
> host git服务器地址   
      User git登录名
* 手动git下代码，确保ssh knownhost包含git服务器信息

### 2. 多项目配置最佳实践
1. 一个项目对应2个git仓库，一个存储代码，一个存储配置。命名规范：项目名-config
2. 项目名-config仓库存储配置信息，配置文件命名规范为：
* 项目名.yml
* 项目名-dev.yml
* 项目名-test.yml
* 项目名-prod.yml
3. 多版本的处理方式;由于接口会有多个版本存在，此时代码和配置文件都采用分支的方式。注意分支的命名规范：
v版本号；如v1.
    
4. config server 配置信息如下：
```
spring:
  cloud:
    config:
      server:
        git:
          uri: git@172.18.115.136:group1/{application}-config.git
          force-pull: true
      fail-fast: true
```
5. 使用
* 访问主分支，项目名称为project,profile为dev:
http://172.18.101.2:8041/project1-dev.yml
* 访问主分支，项目名称为project,profile为dev:
http://172.18.101.2:8041/project1/dev/master
* 访问v1，项目名称为project,profile为dev:
http://172.18.101.2:8041/project1/dev/v1
        

