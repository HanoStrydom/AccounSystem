package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER", schema = "ACCOUNT_SYSTEM")
public class Member implements Serializable{

    private Long memberID;
    private String memberName;
    private String memberSurname;
    private String contactNum;

    private Set<AccountTransaction> accountTransactions;

    public Member() {
    }

    public Member(Long memberID, String memberName, String memberSurname, String contactNum) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.contactNum = contactNum;
    }

    //GETTERS

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", sequenceName = "ACCOUNT_SYSTEM.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    @Column(name = "MEMBER_NAME")
    public String getMemberName() {
        return memberName;
    }

    @Column(name = "MEMBER_SURNAME")
    public String getMemberSurname() {
        return memberSurname;
    }

    @Column(name = "CONTACT_NUM")
    public String getContactNum() {
        return contactNum;
    }

    //FOREIGN KEY FOR memberID

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "memberID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){

        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    //SETTERS
    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }



    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }


    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }


    //HASH
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


    //TO STRING
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
