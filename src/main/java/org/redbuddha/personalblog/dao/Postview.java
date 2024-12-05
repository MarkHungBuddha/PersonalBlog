/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.dao;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "postviews")
public class Postview {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @Column(name = "ip_address", nullable = false, length = 45)
  private String ipAddress;

  @Column(name = "user_agent")
  private String userAgent;

  @ColumnDefault("CURRENT_TIMESTAMP")
  @Column(name = "viewed_at")
  private Instant viewedAt;
}
