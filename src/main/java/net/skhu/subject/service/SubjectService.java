package net.skhu.subject.service;

import net.skhu.subject.entity.Subject;

public interface SubjectService {
	void save(String name, String department, String professor, int capacity);
	Subject findByDepartment(String department);
}
