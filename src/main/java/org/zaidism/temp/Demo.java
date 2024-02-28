package org.zaidism.temp;

import org.zaidism.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Demo {
  public static void main(String[] args) {
    List<Employee> employees = getEmployeeList();
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    numsMap.put(1, 100);
    numsMap.put(2, 200);
    numsMap.put(3, 300);


    for (Map.Entry<Integer, Integer> value : numsMap.entrySet()) {
      System.out.println(value.getKey());
      System.out.println(value.getValue());
    }


  }
}
