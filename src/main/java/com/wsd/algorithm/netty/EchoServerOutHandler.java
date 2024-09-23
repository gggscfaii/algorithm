package com.wsd.algorithm.netty;

import io.netty.channel.*;

/**
 * @author sdwang
 * @date 2024/9/23
 */
@ChannelHandler.Sharable
public class EchoServerOutHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("write msg: " + msg);
        super.write(ctx, msg, promise);
    }
}
