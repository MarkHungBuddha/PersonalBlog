/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.util;

import com.fasterxml.jackson.databind.JavaType;
import com.google.gson.Gson;
import io.jsonwebtoken.io.SerializationException;
import java.nio.charset.Charset;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis使用Gson序列化
 *
 * @param <T> 序列化對象類型
 */
public class GsonRedisSerializer<T> implements RedisSerializer<T> {
  public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private Class<T> clazz;
  private final Gson gson;

  static {
    // Gson不需要特別的全局配置
  }

  public GsonRedisSerializer(Class<T> clazz) {
    super();
    this.clazz = clazz;
    this.gson = new Gson();
  }

  @Override
  public byte[] serialize(T t) throws SerializationException {
    if (t == null) {
      return new byte[0];
    }
    return gson.toJson(t).getBytes(DEFAULT_CHARSET);
  }

  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }
    String str = new String(bytes, DEFAULT_CHARSET);

    return gson.fromJson(str, clazz);
  }

  protected JavaType getJavaType(Class<T> clazz) {
    // Gson不需要這個方法，但為了保持接口一致，我們保留它
    return null;
  }
}
