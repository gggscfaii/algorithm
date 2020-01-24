package com.wsd.algorithm.netty;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by sdwang on 2020/1/17.
 */
public class TestByteBuf {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(32);
        byteBuf.writeBytes("abc".getBytes(Charsets.UTF_8));

        byte[] bytes = new byte[6];
        byteBuf.readBytes(bytes);
        System.out.println(new String(bytes));
    }
}
