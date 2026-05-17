package net.skhu.subject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.skhu.subject.entity.Subject;
import net.skhu.subject.repository.SubjectRepository;

@Service
@RequiredArgsConstructor
public class BaseSubjectService implements SubjectService{
	private final SubjectRepository SubjectRepository;
	@Override
	public void save(String name, String department, String professor, String capacity) {
		SubjectRepository.save(new Subject(name, department, professor, capacity));
	}
	
	@Override
	public List<Subject> findByDepartment(String department) {
		List<Subject> subjectDepartmentOptional = SubjectRepository.findByDepartment(department);
		
		return subjectDepartmentOptional;
	};
}
