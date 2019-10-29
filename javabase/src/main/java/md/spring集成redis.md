## spring集成redis学习笔记
### 安装
 \<!--redis与spring集成包--><br>
\<dependency><br>
    \<groupId>org.springframework.data\</groupId><br>
    \<artifactId>spring-data-redis\</artifactId><br>
    \<version>1.7.5.RELEASE\</version><br>
\</dependency>
### 什么是spring-data-redis
spring-data-redis是spring-data模块的一部分,专门用来支持在spring管理项目对redis的操作,使用java操作redis最常用的是使用jedis,但并不是只有jedis可以使用,像jdbc-redis,jredis也都属于redis的java客户端,他们之间是无法兼容的,
如果你在一个项目中使用了jedis,然后后来决定弃用掉改用jdbc-redis就比较麻烦了,spring-data-redis提供了redis的java客户端的抽象,在开发中可以忽略掉切换具体的客户端所带来的影响,而且他本身就属于spring的一部分,比起单纯的使用jedis,更加稳定.管理起来更加自动化.(当然jedis的缺点不止以上).
### spring-data-redis的特性
  1.自动管理连接池,提供了一个高度封装的RedisTemplate类

  2.针对jedis客户端的大量api进行了归类封装,把同一类型的操作封装成了Operation接口.支持redis中的五种数据类型的操作.

　3.针对数据的"序列化与反序列化",提供了多种可以选择的策略(RedisSerializer)

    JdkSerializationRedisSerializer：当需要存储java对象时使用.

    StringRedisSerializer：当需要存储string类型的字符串时使用.

    JacksonJsonRedisSerializer：将对象序列化成json的格式存储在redis中,需要jackson-json工具的支持,(目前我还没使用过,不了解)
### Operations
通过redisTemplate获得对应的操作，目前有7种操作，redis的5种数据类型分别对应一种操作，加上集群操作ClusterOperations、HyperLogLogOperations
redisTemplate有两个方法经常用到,一个是opsForXXX一个是boundXXXOps,XXX是value的类型,前者获取到一个Opercation,
但是没有指定操作的key,可以在一个连接(事务)内操作多个key以及对应的value;后者会获取到一个指定了key的operation,在一个连接内只操作这个key对应的value.
#### ValueOperation和BoundValueOperation
```java
 ValueOperations valueOperations = redisTemplate.opsForValue();
 BoundValueOperations<String, User> boundValueOps = redisTemplate.boundValueOps("key");
```
 ValueOperation可以缓存Integer,String,java对象等类型.使用.set(key,value)方法进行设置,get(key)方法用来获取.
 同样的方式可以获取ListOperations对象,可以用来缓存List,此外还有SetOperation,HashOperation
