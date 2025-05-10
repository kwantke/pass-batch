package com.fastcampus.pass.repository;

import com.fastcampus.pass.repository.packaze.PackageEntity;
import com.fastcampus.pass.repository.packaze.PackageRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
public class PackageRepositoryTest {

  @Autowired
  private PackageRepository packageRepository;

  @Test
  void test_save() {
    //Given
    PackageEntity packageEntity = new PackageEntity();
    packageEntity.setPackageName("바디 챌린지 PT 12주");
    packageEntity.setPeriod(84);
    //When
    packageRepository.save(packageEntity);

    //Then
    assertNotNull(packageEntity.getPackageSeq());

  }

  @Test
  void test_findByCreatedAtAfter() {
    //Given
    LocalDateTime dateTime = LocalDateTime.now().minusMinutes(1);

    PackageEntity packageEntity0 = new PackageEntity();
    packageEntity0.setPackageName("학생 전용 3개월");
    packageEntity0.setPeriod(90);
    packageRepository.save(packageEntity0);

    PackageEntity packageEntity1 = new PackageEntity();
    packageEntity1.setPackageName("학생 전용 6개월");
    packageEntity1.setPeriod(180);
    packageRepository.save(packageEntity1);

    //When
    final List<PackageEntity> packageEntityList = packageRepository.findByCreatedAtAfter(dateTime, PageRequest.of(0, 1, Sort.by("packageSeq").descending()));

    //Then
    assertEquals(1, packageEntityList.size());
    assertEquals(packageEntity1.getPackageSeq(), packageEntityList.get(0).getPackageSeq());
  }


}
