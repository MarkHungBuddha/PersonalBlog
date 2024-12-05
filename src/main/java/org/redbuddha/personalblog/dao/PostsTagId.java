/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class PostsTagId implements Serializable {
  private static final long serialVersionUID = 7562996337823366882L;

  @Column(name = "post_id", nullable = false)
  private Integer postId;

  @Column(name = "tag_id", nullable = false)
  private Integer tagId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    PostsTagId entity = (PostsTagId) o;
    return Objects.equals(this.tagId, entity.tagId) && Objects.equals(this.postId, entity.postId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagId, postId);
  }
}
