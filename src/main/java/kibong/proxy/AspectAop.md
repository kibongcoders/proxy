# @Aspect 프록시 AOP

매우 편리하게 Pointcut과 Advice로 구성되어 있는 Advisor 생성 기능을 지원하는 애노테이션이다.

## @Aspect 프록시 적용 과정
@Aspect 애노테이션 붙은 거를 Advisor로 변환 하는건 다음 과정을 거친다.
1. 스프링 어플리케이션 로딩 시점에 자동 프록시 생성기 호출
2. 모든 @Aspect 애노테이션이 붙은 스프링 빈 모두 조회
3. @Aspect Advisor 빌더를 통해 @Aspect 애노테이션 정보를 기반으로 Advisor 생성
4. 생성한 Advisor를 @Aspect Advisor 빌더 내부에 저장

@Aspect가 적용된 자동 프록시 생성기의 작동 과정을 보면
1. 대상 객체 생성
2. 자동 프록시 생성기에 전달
3. Advisor 조회
4. 프록시 적용 대상 체크
5. 프록시 생성
6. 스프링 컨테이너에 빈 등록

해당 과정으로 자동 프록시 생성기가 작동하는데 여기서 3번 Advisor 조회에서 스프링 컨테이너에 있는 모든 Advisor 빈과
@Aspect Advisor 빌더 내부에 저장된 Adviosr를 모두 조회한다.

## @Aspect 프록시 적용
1. @Aspect가 붙은 클래스 생성
2. @Around를 통해 범위를 지정(Pointcut) @Around가 붙은 메서드는 Advice가 된다.
3. ProceedingJoinPoint를 통해 정보 및 호출 대상을 호출 할 수 있다.
4. @Configuration 클래스를 통해 @Aspect가 붙은 클래스 Bean 등록

## @Aspect 프록시 설명
자동 프록시 생성기 AnnotationAwareAspectJAutoProxyCreator는 Advisor를 찾아와서 프록시를 생성 적용하기도 하지만
@Aspect를 찾아서 Advisor를 만들어주기도 한다.

1. @Aspect 기준으로 Advisor를 변환 빌더에 저장
2. Advisor를 기반으로 프록시 생성
