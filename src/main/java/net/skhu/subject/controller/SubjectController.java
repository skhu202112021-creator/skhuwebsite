package net.skhu.subject.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.skhu.account.dto.AccountLoginRequest;
import net.skhu.member.entity.Professor;
import net.skhu.member.entity.Student;
import net.skhu.member.service.ProfessorService;
import net.skhu.member.service.StudentService;
import net.skhu.subject.dto.SubjectSaveRequest;
import net.skhu.subject.entity.Subject;
import net.skhu.subject.helper.SubjectHelper;
import net.skhu.subject.service.SubjectService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SubjectController {
	private final SubjectService SubjectService;
	private final StudentService StudentService;
	private final ProfessorService ProfessorService;
	private final SubjectHelper SubjectHelper;
	public String loginId = "";
	public String loginPw = "";
	public Professor p;
	@PostMapping("/api/subject/listCheck")
	public ResponseEntity<?> listCheck(@RequestBody AccountLoginRequest request){
		Student s = StudentService.find(request.getLoginId(), request.getLoginPw());
		if(s == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/api/subject/list")
	public List<Subject> list(@RequestBody AccountLoginRequest request){
		Student s = StudentService.find(request.getLoginId(), request.getLoginPw());
		if(s != null) {
			List<Subject> Subject = SubjectService.findByDepartment(s.getDepartment());
			return Subject;
		}
		return null;
	}
	@PostMapping("/api/subject/listCheck2")
	public ResponseEntity<?> listCheck2(@RequestBody AccountLoginRequest request){
		Professor p = ProfessorService.find(request.getLoginId(), request.getLoginPw());
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/api/subject/list2")
	public List<Subject> list2(@RequestBody AccountLoginRequest request){
		p = ProfessorService.find(request.getLoginId(), request.getLoginPw());
		if(p != null) {
			List<Subject> Subject = SubjectService.findByDepartment(p.getDepartment());
			return Subject;
		}
		return null;
	}
	@PostMapping("/api/subject/save")
    public ResponseEntity<?> save(@RequestBody SubjectSaveRequest subjectReq) {
        // 입력 값이 비어 있다면
        if (!StringUtils.hasLength(subjectReq.getName()) || !StringUtils.hasLength(subjectReq.getCapacity())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        SubjectHelper.save(subjectReq, p.getDepartment(), p.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
