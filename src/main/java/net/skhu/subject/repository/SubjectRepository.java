package net.skhu.subject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.subject.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	Optional<Subject> findByDepartment(String department);
}
