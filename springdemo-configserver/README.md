### 配置信息使用git管理注意事项
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
