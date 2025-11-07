package com.example.employee_management.repository;

import com.example.employee_management.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // JpaRepository<Tên_Entity, Kiểu_dữ_liệu_của_ID>
    
    // Spring Data JPA sẽ tự động cung cấp các hàm:
    // 1. save() (dùng để Thêm mới hoặc Cập nhật)
    // 2. findById() (Tìm theo ID)
    // 3. findAll() (Lấy tất cả)
    // 4. deleteById() (Xóa theo ID)
}