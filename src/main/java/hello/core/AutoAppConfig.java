package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@Component 애노테이션을 스캔
        //1. defalut : 기본은 @ComponentScan이 붙은 설정정보 클래스가 위치가 된다.
        //2. 스캔 시작할 위치 지정
//        basePackages = "hello.core.member",
        //3. 스캔 시작할 클래스(가 있는 패키지) 지정
//        basePackageClasses = AutoAppConfig.class,
        //4. 제외 적용
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    //@ComponentScan을 사용하면 @Configuration 애노테이션이 붙은 클래스도 자동으로 스캔함

    //수동 등록빈이 우선권을 가져 자동빈을 오버라이딩한다
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
