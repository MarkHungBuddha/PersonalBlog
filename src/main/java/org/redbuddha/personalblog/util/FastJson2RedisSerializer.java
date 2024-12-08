/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import io.jsonwebtoken.io.SerializationException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis使用FastJson2序列化
 *
 * @param <T> 序列化對象類型
 */
public class FastJson2RedisSerializer<T> implements RedisSerializer<T> {

  public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

  private final Class<T> clazz;

  public FastJson2RedisSerializer(Class<T> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(T t) throws SerializationException {
    if (t == null) {
      return new byte[0];
    }
    try {
      return JSON.toJSONString(
              t,
              JSONWriter.Feature.PrettyFormat,
              JSONWriter.Feature.WriteMapNullValue,
              JSONWriter.Feature.WriteEnumsUsingName)
          .getBytes(DEFAULT_CHARSET);
    } catch (Exception ex) {
      throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
    }
  }

  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }

    try {
      String str = new String(bytes, DEFAULT_CHARSET);
      // 使用更嚴格的解析模式，提高安全性
      return JSON.parseObject(
          str, clazz, JSONReader.Feature.SupportAutoType, JSONReader.Feature.IgnoreSetNullValue);
    } catch (Exception ex) {
      throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
    }
  }
}
