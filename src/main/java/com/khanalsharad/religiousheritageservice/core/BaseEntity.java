package com.khanalsharad.religiousheritageservice.core;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity<PK extends Serializable> extends AbstractPersistable<PK> {
    @CreatedDate
    @Column(name="created_at")

}
