package com.mkyong.web.repository;

import com.mkyong.web.entity.Question;
import com.mkyong.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question t WHERE t.user_id = :id",
            nativeQuery=true
    )
    List<Question> findByUser(@Param("id") Long id);

    @Query("select t from Question t where t.id = :id")
    Question findById(@Param("id") Long id);
}
