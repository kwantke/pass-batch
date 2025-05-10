package com.fastcampus.pass.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//jpa 를 사용해서 엔티티를 테이블에 매칭할때, 공통적으로 엔티티를 가지고 있는 필드 컬럼들이
//존재합니다. 대표적으로는 생성일시 수정일시 등 필드
// JPA auditing을 활성화합니다. 본 프로젝트에서는 entity의 생성일시와 수정일시를 자동화하는 용도로 사용합니다.
@EnableJpaAuditing
@Configuration
public class JpaConfig {

}
