package com.example.demo.repo;

import com.example.demo.model.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<AppUser,Long> {
    AppUser findAllByUsername (String username);
}
