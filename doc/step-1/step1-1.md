# Spring Security Properties 기반으로 간단 설정


## application
```yum
security:
  user:
    name: user
    password: pass
  basic:
    authorize-mode: authenticated
    path: /**
```

```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //@formatter:off
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}pass").roles("USER");
        //@formatter:on

    }
}
```

* properties 설정으로 user의 name, password 간단 설정
* SecurityConfig 에서 properties에 등록된 user security 허용 설정
* security 5.0 부터 (정확하진 않음) password encoder 설정이 필요함 간단하게 위회 하는 방법은 앞에 {noop} 추가하면 됨 password 설정 할 경우 `{noop}pass`