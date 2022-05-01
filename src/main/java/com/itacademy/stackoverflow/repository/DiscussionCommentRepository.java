package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.DiscussionCommentEntity;
import com.itacademy.stackoverflow.entity.DiscussionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface DiscussionCommentRepository extends JpaRepository<DiscussionCommentEntity,Long> {
    @Query(nativeQuery = true,value = "select d.duscussion_id from discussion_comment d where d.comment_id =:id")
    Long getByCommentEntityId(Long id);
    List<DiscussionCommentEntity> findAllDiscussionByCommentEntityId(Long id);
    List<DiscussionCommentEntity> findByCommentEntityId(Long id);
}
