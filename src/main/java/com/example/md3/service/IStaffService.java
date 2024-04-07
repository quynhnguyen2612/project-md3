package com.example.md3.service;
import com.example.md3.model.Staff;


import java.util.List;

public interface IStaffService<E> {
    void add(E e);
    Staff findById(int id);
    void edit(int id, E e);
    void delete(int id);
    List<E> findAll();

    List<Staff> searchByName(String str);
}
