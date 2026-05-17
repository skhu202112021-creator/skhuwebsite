package net.skhu.subject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.subject.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	List<Subject> findByDepartment(String department);
}
