# 秒杀系统

## 数据库设计


## 通用模块

### 参数校验
jsr参数校验方式
* 自定义注解校验手机号格式
* resolveArgument方式拦截入参参数，进行通用参数校验

### 异常处理

* 自定义异常和错误对照码
* 全局异常处理抛出的异常

## 登录模块
### 加密方式

两次MD5加密方式

* 固定salt加密方式
* 随机salt加密方式，使用apache的随机字符串方式生成随机盐

## Redis模块和处理方式
* Jedis自定义redis连接池
* jedis处理对象和string相互转换
* 模板模式为对象加入前缀