package com.hwua.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Order {

  private String id;
  private String orderNum;
  private String orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private long orderStatus;
  private String memberId;
  private Product product;

}
