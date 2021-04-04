package com.geektime.oop._07;

/**
 * @author xschen
 *
 * 滥用全局变量和全局方法：在一段代码中，将程序中所有用到的常量，都集中放到Contants类中，影响代码可维护性。
 *      1、Contants会越来越大，增加提交代码冲突的概率。
 *
 *      2、增加代码的编译时间。
 *          当 Constants 类中包含很多常量定义的时候，依赖这个类的代码就会很多。
 *          那每次修改 Constants 类，都会导致依赖它的类文件重新编译，因此会浪费很多不必要的编译时间。
 *          不要小看编译花费的时间，对于一个非常大的工程项目来说，编译一次项目花费的时间可能是几分钟，甚至几十分钟。
 *          而我们在开发过程中，每次运行单元测试，都会触发一次编译的过程，这个编译时间就有可能会影响到我们的开发效率。
 *
 *      3、影响代码的复用性：
 *             如果我们要在另一个项目中，复用本项目开发的某个类，而这个类又依赖 Constants 类。
 *              即便这个类只依赖 Constants 类中的一小部分常量，我们仍然需要把整个 Constants 类也一并引入，
 *              也就引入了很多无关的常量到新的项目中。
 *
 * 改进：两种思路
 *      1、将 Constants 类拆解为功能更加单一的多个类，比如跟 MySQL 配置相关的常量，我们放到 MysqlConstants 类中；
 *          跟 Redis 配置相关的常量，我们放到 RedisConstants 类中。
 *
 *      2、不单独地设计 Constants 常量类，而是哪个类用到了某个常量，我们就把这个常量定义到这个类中。
 *          比如，RedisConfig 类用到了 Redis 配置相关的常量，那我们就直接将这些常量定义在 RedisConfig 中，
 *          这样也提高了类设计的内聚性和代码的复用性
 *
 * Utils类：
 *      设计 Utils 类的时候，最好也能细化一下，针对不同的功能，设计不同的 Utils 类，
 *      比如 FileUtils、IOUtils、StringUtils、UrlUtils 等，不要设计一个过于大而全的 Utils 类。
 */


public class Constants {
    public static final String MYSQL_ADDR_KEY = "mysql_addr";
    public static final String MYSQL_DB_NAME_KEY = "db_name";
    public static final String MYSQL_USERNAME_KEY = "mysql_username";
    public static final String MYSQL_PASSWORD_KEY = "mysql_password";
    public static final String REDIS_DEFAULT_ADDR = "192.168.7.2:7234";
    public static final int REDIS_DEFAULT_MAX_TOTAL = 50;
    public static final int REDIS_DEFAULT_MAX_IDLE = 50;
    public static final int REDIS_DEFAULT_MIN_IDLE = 20;
    public static final String REDIS_DEFAULT_KEY_PREFIX = "rt:";
    // ...省略更多的常量定义...
}
