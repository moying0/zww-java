package com.bfei.icrane.game;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NclientHandler extends SimpleChannelInboundHandler<ByteBuf>{
	
	  @Override  
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
	        cause.printStackTrace();  
	        ctx.close();  
	    }  
	  
	    @Override  
	    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {  
	        //System.out.println(msg.toString(Charset.forName("UTF-8")));
	    }
}
