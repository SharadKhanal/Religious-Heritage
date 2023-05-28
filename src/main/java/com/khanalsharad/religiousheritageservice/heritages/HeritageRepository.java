package com.khanalsharad.religiousheritageservice.heritages;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeritageRepository extends JpaRepository<Heritage,Long> {


}
