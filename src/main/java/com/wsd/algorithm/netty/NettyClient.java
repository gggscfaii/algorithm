package com.wsd.algorithm.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by sdwang on 2019/11/2.
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap =
                new Bootstrap()
                        .group(new NioEventLoopGroup(4))
                        .channel(NioSocketChannel.class)
                        .remoteAddress(new InetSocketAddress("localhost", 9999))
//                        .option(ChannelOption.TCP_NODELAY, true)
                        .option(ChannelOption.SO_KEEPALIVE, true) // (4)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline p = socketChannel.pipeline();
//                                p.addLast(new LoggingHandler(LogLevel.DEBUG));
                                p.addLast(new ClientHandle());
                            }
                        });

        ChannelFuture f = bootstrap.connect().sync();
//        sync.channel().write("Hello world");
        f.channel().closeFuture().sync();
    }
}
