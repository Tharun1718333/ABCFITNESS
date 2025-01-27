package com.example.springboot.Models;

public class Member {
    public int memberId;
    public String memberName;

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Member() {
    }
}
