package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Map<Long,Member> store = new HashMap<>();
    private static long sequence= 0L; //static이라서!

    private static final MemberRepository instance = new MemberRepository();


    public static MemberRepository getInstance(){
        return instance;
    }
    //singletone
    private MemberRepository(){

    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    public  Member findById(Long id){
        return store.get(id);

    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store에 있는 value를 건들고 싶지 않아서 store 보호

    }
    public void clearStore(){
        store.clear();
    }
}
