# 목차

# Lesson 1: By URL Authorization with Expressions

* 보안 페이지에 다양한 유형의 권한을 설정합니다.

## hasIpAddress

```java
.antMatchers("/secured").hasIpAddress("192.168.1.0/24")
```
* 해당 아이피가 아니면 접근하면 403 응답 받게됩니다.

## negating an expression - not
```
.antMatchers("/secured").not().access("hasIpAddress('::1')")
```

## logical concatenation of expressions
```
.antMatchers("/secured").access("hasRole('ROLE_ADMIN') and principal.username == 'user'")
.antMatchers("/secured").access("hasRole('ROLE_ADMIN') or principal.username == 'user'")
```
* 여러 표현식을 연결하여 더욱 강력하고 유연한 표현식을 만들 수 있습니다.
* 


 ## logical concatenation of expressions 

# Lesson 2: On-method Authorization with Expressions

# Lesson 3: In-page URL Authorization with Expressions

#  Lesson 4: Programmatic Expressions and a custom PermissionEvaluator