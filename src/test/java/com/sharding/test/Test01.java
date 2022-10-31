package com.sharding.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharding.entity.Order;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Test01 {
    public static void main(String[] args) throws JsonProcessingException, DecoderException, UnsupportedEncodingException {
        Order order = new Order();
        order.setOrderId("123456");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(order));
        byte[] bytes = Hex.decodeHex("2eb7fd33f53ecbe19559e61ce7077ec8");
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

    }

    public static void copyFileByChannel(File source, File dest) throws
            IOException {
        try (FileChannel sourceChannel = new FileInputStream(source)
                .getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel();
             )
        {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(
                        sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }

}
