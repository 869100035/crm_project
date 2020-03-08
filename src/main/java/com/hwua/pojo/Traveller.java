package com.hwua.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Traveller {

  private String id;
  private String name;
  private String sex;
  private String phoneNum;
  private long credentialsType;
  private String credentialsNum;
  private long travellerType;


}
