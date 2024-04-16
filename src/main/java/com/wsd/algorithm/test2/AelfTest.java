package com.wsd.algorithm.test2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AelfTest {

    public static void main(String[] args) {


        AtomicInteger flag = new AtomicInteger(0);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                while (flag.get() != 1) {
                }

                System.out.println(Thread.currentThread().getName() + "---" + "ab");
                flag.set(2);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                while (flag.get() != 2) {
                }

                System.out.println(Thread.currentThread().getName() + "---" + "ab");
                flag.set(1);
            }
        }).start();

        flag.set(1);


//        Discount group by 区别
//        Mvcc 版本格式
//        RC和RR加锁过程 gap锁
//        abc索引读取过程
//                熔断策略
//        线程池并发执行策略
//        netty 拆包/粘包
//                布隆过滤器
//        Redis 多主多从，一主多从
//                mysql的主从同步策略
//        FutureTask
//                kafka必须消费一次成功
//
//        spring三级缓存
//                缓存击穿
//        concurrenthashmap
//                kafka优势
//
//
//        分布式锁
//        数据库 优点：简单 缺：性能
//        redis 优点：高并发 缺：死锁
//        zk 优点：控制顺序加锁 缺：性能不如redis
//                分库分表
//        跳表时间复杂度
//                spring三级缓存
//        spring refresh
//        Redis 高可用
//        java 发号器
//        幻读
//        Redo log/ undo log
//        Mysql acid原理
//        Redis可重入锁
//        缓存穿透 限流，加锁，布隆
//        缓存击穿 虚拟对象
//        缓存雪崩 长期有效，随时过期时间
//        redis的数据类型  string list hset set
//        redis 内存淘汰策略
//        tomcat 线程池 借助java内部线程池，超出限制会重试
//        java 线程池 非核心线程终止
//        volatile 底层
//                内存泄露
//        多态底层原理
//                双亲委派
//        消息队列扩容
//                redis主从切换
//        长链接
//                布隆过滤器
//
//        es节点类型
// 1.主节点（Master 节点）
//  2.数据节点（Data节点）
//  3.负载均衡节点（Client节点）
//  4.预处理节点（Ingest节点）
        // 限流方式的区别


    }
}
