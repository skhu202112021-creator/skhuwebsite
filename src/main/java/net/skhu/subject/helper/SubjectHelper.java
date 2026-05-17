package net.skhu.subject.helper;

import org.springframework.stereotype.Component;

import net.skhu.subject.dto.SubjectSaveRequest;

@Component
public interface SubjectHelper {
	void save(SubjectSaveRequest subjectReq, String department, String professor);
}
