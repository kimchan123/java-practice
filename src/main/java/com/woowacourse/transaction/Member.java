package com.woowacourse.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    protected Member() {
    }

    public Member(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Member(final String name) {
        this(null, name);
    }

    public void changeName(String name) {
        this.name = name;
    }
}
