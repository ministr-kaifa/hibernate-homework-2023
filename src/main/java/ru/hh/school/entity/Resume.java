package ru.hh.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "resume")
public class Resume {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_id_seq")
  @SequenceGenerator(name = "resume_id_seq", sequenceName = "resume_id_seq", allocationSize = 10)
  private Integer id;

  private String description;

  public Resume() {
  }

  public Resume(String description) {
    this.description = description;
  }

}
