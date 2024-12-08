/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "status", nullable = false)
  private UserStatus status;

  @Column(name = "meta_description")
  private String metaDescription;

  @Column(name = "slug", nullable = false)
  private String slug;

  @ColumnDefault("0")
  @Column(name = "views_count")
  private Integer viewsCount;

  @ColumnDefault("0")
  @Column(name = "likes_count")
  private Integer likesCount;

  @Column(name = "published_at")
  private Instant publishedAt;

  @ColumnDefault("CURRENT_TIMESTAMP")
  @Column(name = "created_at")
  private Instant createdAt;

  @ColumnDefault("CURRENT_TIMESTAMP")
  @Column(name = "updated_at")
  private Instant updatedAt;

  @Column(name = "deleted_at")
  private Instant deletedAt;
}
