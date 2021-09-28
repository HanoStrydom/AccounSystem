package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBER", schema = "ACCOUNT_SYSTEM")
public class Member implements Serializable{

    private Long memberID;
    private Long memberName;
    private Long memberSurname;
    private Long contactNum;

    public Member() {
    }

    public Member(Long memberID, Long memberName, Long memberSurname, Long contactNum) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.contactNum = contactNum;
    }

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", sequenceName = "ACCOUNT_SYSTEM.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "MEMBER_NAME")
    public Long getMemberName() {
        return memberName;
    }

    public void setMemberName(Long memberName) {
        this.memberName = memberName;
    }

    @Column(name = "MEMBER_SURNAME")
    public Long getMemberSurname() {
        return memberSurname;
    }

    public void setMemberSurname(Long memberSurname) {
        this.memberSurname = memberSurname;
    }

    @Column(name = "CONTACT_NUM")
    public Long getContactNum() {
        return contactNum;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(memberName, member.memberName) && Objects.equals(memberSurname, member.memberSurname) && Objects.equals(contactNum, member.contactNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, memberSurname, contactNum);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName=" + memberName +
                ", memberSurname=" + memberSurname +
                ", contactNum=" + contactNum +
                '}';
    }
}
