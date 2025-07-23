package com.stmnsys.model;

import java.io.Serializable;

public record Student(int id, String name, int age, String major)
    implements Serializable {
  private static final long serialVersionUID = 1L;
}
