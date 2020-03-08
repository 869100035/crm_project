package com.hwua.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String id;
  private String email;
  private String username;
  private String password;
  private String phoneNum;
  private long status;
}