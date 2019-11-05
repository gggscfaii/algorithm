package com.wsd.algorithm.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by sdwang on 2019/11/2.
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup parentGroup = new NioEventLoopGroup(1);
        EventLoopGroup childGroup = new NioEventLoopGroup(1);

        ServerBootstrap server =
                new ServerBootstrap()
                        .group(parentGroup, childGroup)
                        .channel(NioServerSocketChannel.class)
                        .localAddress(9999)
//                        .childOption(ChannelOption.TCP_NODELAY, true)
                        .childOption(ChannelOption.SO_KEEPALIVE, true) // (6)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel channel) throws Exception {
                                ChannelPipeline p = channel.pipeline();
//                                p.addLast(new LoggingHandler(LogLevel.DEBUG));
                                p.addLast(new ServerHandle());
                            }
                        });
        ChannelFuture f = server.bind().sync();
        System.out.println("started and listen on " + f.channel().localAddress());
        f.channel().closeFuture().sync();
    }

}
