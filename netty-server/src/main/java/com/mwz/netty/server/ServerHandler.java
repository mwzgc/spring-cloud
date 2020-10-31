package com.mwz.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * @author mwz
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter { // (1)

    /**
     * 连接成功
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        String content = "channelActive";
//        ctx.writeAndFlush(content);
//        System.out.println(content);
    }

    /**
     * 读取数据
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        try {
            String content = msg.toString();
            log.info("read: {}", content);
//            ctx.writeAndFlush("echo: " + content);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
