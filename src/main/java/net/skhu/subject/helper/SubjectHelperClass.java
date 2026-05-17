package net.skhu.subject.helper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import net.skhu.subject.dto.SubjectSaveRequest;
import net.skhu.subject.service.SubjectService;

@Component
@RequiredArgsConstructor
public class SubjectHelperClass implements SubjectHelper {
	private final SubjectService SubjectService;
	
	@Override
	public void save(SubjectSaveRequest subjectReq, String department, String professor) {
        SubjectService.save(subjectReq.getName(), department, professor, subjectReq.getCapacity());
    }
}
