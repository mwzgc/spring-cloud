package com.mwz.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;


/**
 * @author mwz
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {


    private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * 连接成功
     *
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();

        String content = "connect server success ~~~~ \n";
        ctx.writeAndFlush(content);
        log.info(channel.remoteAddress() + " : " + content);

        group.writeAndFlush(channel.remoteAddress() + "---上线 \n");
        group.add(channel);
    }

    /**
     * 断开连接
     *
     * @param ctx
     */
    @Override
    public void channelInactive(final ChannelHandlerContext ctx) {
        String content = "lost connect ~~~~ \n";
        log.info(content);
    }

    /**
     * 读取数据
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            String content = msg.toString();
            log.info("read: {}", content);
//            ctx.writeAndFlush("echo: " + content + "\n");
            group.writeAndFlush("echo: " + content + "\n");
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
