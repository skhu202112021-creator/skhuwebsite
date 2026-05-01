package net.skhu.account.helper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.skhu.account.dto.AccountJoinRequest;
import net.skhu.account.dto.AccountLoginRequest;
import net.skhu.account.etc.AccountConstants;
import net.skhu.common.util.HttpUtils;
import net.skhu.member.entity.Professor;
import net.skhu.member.entity.Student;
import net.skhu.member.service.ProfessorService;
import net.skhu.member.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAccountStudentHelper implements AccountHelper {

    private final StudentService StudentService;
    private final ProfessorService ProfessorService;

    // 회원가입
    @Override
    public void join2(AccountJoinRequest joinReq) {
        StudentService.save(joinReq.getName(), joinReq.getDepartment(), joinReq.getLoginId(), joinReq.getLoginPw());
    }
    
    @Override
    public void join1(AccountJoinRequest joinReq) {
        ProfessorService.save(joinReq.getName(), joinReq.getDepartment(), joinReq.getLoginId(), joinReq.getLoginPw());
    }
    // 로그인
    @Override
    public String login2(AccountLoginRequest loginReq, HttpServletRequest req, HttpServletResponse res) { // ④
        Student Student = StudentService.find(loginReq.getLoginId(), loginReq.getLoginPw());
        // 회원 데이터가 없으면
        if (Student == null) {
            return null;
        }
        HttpUtils.setSession(req, AccountConstants.MEMBER_ID_NAME, Student.getId());
        return Student.getLoginId();
    }
    @Override
    public String login1(AccountLoginRequest loginReq, HttpServletRequest req, HttpServletResponse res) { // ④
        Professor Professor = ProfessorService.find(loginReq.getLoginId(), loginReq.getLoginPw());
        // 회원 데이터가 없으면
        if (Professor == null) {
            return null;
        }
        HttpUtils.setSession(req, AccountConstants.MEMBER_ID_NAME, Professor.getId());
        return Professor.getLoginId();
    }

    // 회원 아이디 조회
    @Override
    public Integer getMemberId(HttpServletRequest req) { // ④
        Object StudentId = HttpUtils.getSessionValue(req, AccountConstants.MEMBER_ID_NAME);

        if (StudentId != null) {
            return (int) StudentId;
        }

        return null;
    }

    // 로그인 여부 확인
    @Override
    public boolean isLoggedIn(HttpServletRequest req) { // ④
        return getMemberId(req) != null;
    }

    // 로그아웃
    @Override
    public void logout(HttpServletRequest req, HttpServletResponse res) { // ④
        HttpUtils.removeSession(req, AccountConstants.MEMBER_ID_NAME);
    }
}