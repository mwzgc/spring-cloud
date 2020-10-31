package com.mwz.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author mwz
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    String lineSeparator = System.getProperty("line.separator");

    int count = 500;

    /**
     * 连接成功
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        for (int i = 0; i < count; i++) {
            String content = String.format("[%d] client connect success" + lineSeparator, i);
            ctx.writeAndFlush(content);
        }
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            String content = msg.toString();
            System.out.println("read: " + content);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
