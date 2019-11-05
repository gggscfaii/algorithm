package com.wsd.algorithm.netty;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by sdwang on 2019/11/2.
 */
public class ClientHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String command = "client active";
        ByteBuf byteBuf = Unpooled.buffer(EchoClient.SIZE);
        byteBuf.writeBytes(command.getBytes(Charsets.UTF_8));
        ctx.writeAndFlush(byteBuf);
//        super.channelActive(ctx);
//        final ChannelFuture f = ctx.writeAndFlush("client active");
//        f.addListener((ChannelFutureListener) future -> {
//            assert f == future;
//            ctx.close();
//        });
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(info() + "read");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(info() + "registered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(info() + "unregistered");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(info() + "inactive");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(info() + "readComplete");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(info() + "triggered");
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(info() + "changed");
    }

    protected String info() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() + " " + this.getClass().getSimpleName() + ": ";
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }}

