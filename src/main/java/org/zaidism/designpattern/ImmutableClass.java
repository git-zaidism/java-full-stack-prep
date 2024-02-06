package org.zaidism.designpattern;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

  private final int id;
  private final List<String> subject;


  public ImmutableClass(int id, List<String> subject) {
    this.id = id;
    this.subject = new ArrayList<>(subject);
  }

  public int getId() {
    return id;
  }

  public List<String> getSubject() {
    return new ArrayList<>(subject);
  }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", subject=" + subject +
                '}';
    }
}

class ImmutableTest {
  public static void main(String[] args) {
    List<String> subject = new ArrayList<>();
    subject.add("subject1");
    ImmutableClass immutableClass = new ImmutableClass(1, subject);
    immutableClass.getSubject().add("rr");
    System.out.println(immutableClass);
  }
}
