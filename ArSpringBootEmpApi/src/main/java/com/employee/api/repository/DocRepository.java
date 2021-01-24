package com.employee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.api.model.Doc;

public interface DocRepository  extends JpaRepository<Doc,Integer>{

}
