package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final EntityManager em;
    private final DataSource dataSource;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource, MemberRepository memberRepository) {
        this.em = em;
        this.dataSource = dataSource;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    //Aop는 bean에 명시하는 게 좋음.
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository()
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
