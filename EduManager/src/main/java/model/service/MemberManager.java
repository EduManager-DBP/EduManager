package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.member.MemberDAO;
import model.domain.member.Member;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스. UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록
 * 하며, 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다. 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는
 * 클래스를 별도로 둘 수 있다.
 */
public class MemberManager {
    private static MemberManager eduManager = new MemberManager();
    private MemberDAO memberDAO;

    private MemberAnalysis memberAnalysis;

    private MemberManager() {
        try {
            memberDAO = new MemberDAO();
            memberAnalysis = new MemberAnalysis(memberDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MemberManager getInstance() {
        return eduManager;
    }

    public int create(Member user) throws SQLException, ExistingMemberException {
        if (memberDAO.existingMember(user.getId()) == true) {
            throw new ExistingMemberException(user.getId() + "는 존재하는 아이디입니다.");
        }
        return memberDAO.create(user);
    }

      public Member findMember(String userId) throws SQLException, MemberNotFoundException {
        Member user = memberDAO.findUser(userId);

        if (user == null) {
            throw new MemberNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
        }
        return user;
    }

    public List<Member> findMemberList() throws SQLException {
        return memberDAO.findMemberList();
    }

    public List<Member> findMemberList(int currentPage, int countPerPage) throws SQLException {
        return memberDAO.findMemberList(currentPage, countPerPage);
    }

    public boolean login(String id, String pwd)
            throws SQLException, MemberNotFoundException, PasswordMismatchException {
        Member member = findMember(id);

        if (!member.matchPassword(pwd)) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
        return true;
    }

    public List<Member> makeFriends(String id) throws Exception {
        return memberAnalysis.recommendFriends(id);
    }

    public MemberDAO getMemberDAO() {
        return this.memberDAO;
    }
}
