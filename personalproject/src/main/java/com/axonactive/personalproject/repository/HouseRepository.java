package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {

}
