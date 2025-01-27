package com.example.springboot.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springboot.Models.Member;

@Repository
public class MemberRepository extends BaseRepository<Member> {

    private static String FILE_PATH = "DatabaseFiles/Members.json";

    public Member GetMemberById(int memberId) {
        List<Member> members = readData(FILE_PATH, Member.class);
        for (Member memberObj : members) {
            if (memberObj.memberId == memberId) {
                return memberObj;
            }
        }
        return null;
    }

    public void AddMember(Member member) {
        List<Member> members = readData(FILE_PATH, Member.class);
        members.add(member);
        writeData(FILE_PATH, members);
    }
}
