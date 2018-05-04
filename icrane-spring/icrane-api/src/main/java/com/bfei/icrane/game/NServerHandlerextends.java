package com.bfei.icrane.game;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NServerHandlerextends extends SimpleChannelInboundHandler<ByteBuf> {  
  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
        ctx.close();  
    }  
  
    @Override  
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)  
            throws Exception {  
        String str = msg.toString(Charset.forName("UTF-8"));  
        str = "辛苦了"+str.substring(str.lastIndexOf(',')+1);
        ctx.writeAndFlush(Unpooled.wrappedBuffer(str.getBytes()));  
    }  
}  
