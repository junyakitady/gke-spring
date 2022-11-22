package com.kitady.gke.spring.jpa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;

/**
 * ITEM Entity
 */
@Data
@Table(name = "ITEM")
public class Item {

  /** PK */
  /** UUID */
  @PrimaryKey
  @Column(name = "UUID")
  private String uuid;

  /** NAME */
  @Column(name = "NAME")
  private String name;

  /** NAMEJP */
  @Column(name = "NAMEJP")
  private String namejp;

  /** BREWERY */
  @Column(name = "BREWERY")
  private String brewery;

  /** TYPE */
  @Column(name = "TYPE")
  private String type;

  /** DIV */
  @Column(name = "DIV")
  private String div;

  /** ITEMNO */
  @Column(name = "ITEMNO")
  private Long itemno;

  /** PRICE */
  @Column(name = "PRICE")
  private BigDecimal price;

  /** EXPLANATION */
  @Column(name = "EXPLANATION")
  private String explanation;

  /** REG_DATE */
  @Column(name = "REGDATE")
  private Date regdate;

  /** TIME_ZONE */
  @Column(name = "TIMEZONE")
  private String timezone;

  /** TIME_STMP */
  @Column(name = "TIMESTMP")
  private Timestamp timestmp;

  /** VERSION */
  @Column(name = "VERSION")
  private Timestamp version;

}
