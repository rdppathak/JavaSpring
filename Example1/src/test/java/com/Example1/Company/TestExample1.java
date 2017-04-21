package com.Example1.Company;

import org.testng.annotations.Test;
import com.Example1.Company.Role.*;

public class TestExample1 {
  @Test
  public void CreateRole() {
	  Role r = new Role("Software Engineer", "Programming");
  }
}
