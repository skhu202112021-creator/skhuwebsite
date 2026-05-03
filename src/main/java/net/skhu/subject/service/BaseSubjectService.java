package net.skhu.subject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.skhu.subject.entity.Subject;
import net.skhu.subject.repository.SubjectRepository;

@Service
@RequiredArgsConstructor
public class BaseSubjectService implements SubjectService{
	private final SubjectRepository SubjectRepository;
	@Override
	public void save(String name, String department, String professor, int capacity) {
		SubjectRepository.save(new Subject(name, department, professor, capacity));
	}
	
	@Override
	public Subject findByDepartment(String department) {
		Optional<Subject> subjectDepartmentOptional = SubjectRepository.findByDepartment(department);
		
		return subjectDepartmentOptional.orElse(null);
	};
}
