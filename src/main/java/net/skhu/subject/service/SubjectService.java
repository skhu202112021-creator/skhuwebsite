package net.skhu.subject.service;

import java.util.List;

import net.skhu.subject.entity.Subject;

public interface SubjectService {
	void save(String name, String department, String professor, String capacity);
	List<Subject> findByDepartment(String department);
}
