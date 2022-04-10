package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.AdminComment;

import com.sejong.cultureuniverse.entity.admin.Qna;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.function.Function;

public interface AdminCommentRepository extends JpaRepository<AdminComment,Long> {
//게시물로 댓글 가져오기
@Query("select ac from AdminComment ac " +
        " left join fetch Admin a on ac.admin = a left join fetch Qna q on q = ac.qna " +
        " where ac.qna.questionIdx =:questionIdx " )
    List<AdminComment> getCommentOrderByQuestionIdx(@Param("questionIdx") Long questionIdx);

@EntityGraph(attributePaths =  {"member","admin","qna"})
    List<AdminComment> getAdminCommentByMember_UserIdx(Long userIdx);


}
