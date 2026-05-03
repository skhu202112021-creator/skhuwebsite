package net.skhu.subject.helper;

import org.springframework.stereotype.Component;

@Component
public interface SubjectHelper {
	String list(Integer id, String name, String department, String professor,Integer capacity);
}
