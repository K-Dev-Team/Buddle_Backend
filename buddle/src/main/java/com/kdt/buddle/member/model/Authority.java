package com.kdt.buddle.member.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;

  private String name;

  @JoinColumn(name = "member_idx")
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private Member member;

  public void setMember(Member member) {
    this.member = member;
  }
}