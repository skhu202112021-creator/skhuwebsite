package net.skhu.subject.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.skhu.account.dto.AccountLoginRequest;
import net.skhu.member.entity.Student;
import net.skhu.member.service.StudentService;
import net.skhu.subject.entity.Subject;
import net.skhu.subject.service.SubjectService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SubjectController {
	private final SubjectService SubjectService;
	private final StudentService StudentService;
	public String loginId = "";
	public String loginPw = "";
	@PostMapping("/api/subject/list")
	public String list(@RequestBody AccountLoginRequest request){
		Student s = StudentService.find(request.getLoginId(), request.getLoginPw());
		Subject Subject = SubjectService.findByDepartment(s.getDepartment());
		System.out.println(Subject.getName());
		return Subject.getName();
	}
}
