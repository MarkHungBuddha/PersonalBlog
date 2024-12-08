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
@Table(name = "comments")
public class Comment {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @Column(name = "author_name", nullable = false, length = 50)
  private String authorName;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "is_approved")
  private Boolean isApproved;

  @Column(name = "ip_address", nullable = false, length = 45)
  private String ipAddress;

  @ColumnDefault("CURRENT_TIMESTAMP")
  @Column(name = "created_at")
  private Instant createdAt;
}
