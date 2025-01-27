package com.group3.project_green.Service;

import com.group3.project_green.DTO.PostCommentDTO;
import com.group3.project_green.DTO.PostDTO;
import com.group3.project_green.entity.Member;
import com.group3.project_green.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<PostDTO>getList();

    List<PostDTO>getFoodList();

    List<PostDTO>getAccomList();
    List<PostDTO>getSightsList();
    Page<Post> findByTitleContainingOrContentContaining(String title ,String content, Pageable pageable);
    List<Post> accomfindByTitleContainingOrContentContaining(String title ,String content, Pageable pageable);
    List<Post> foodfindByTitleContainingOrContentContaining(String title ,String content, Pageable pageable);
    List<Post> sightfindByTitleContainingOrContentContaining(String title ,String content, Pageable pageable);
    PostCommentDTO getPostWithCommentCnt(Long pno);

    PostDTO get(Long pno);

    List<PostDTO> getPostList(Long pno);
    Page<Post> getPostListPage(Long pno, String title, String content , Pageable pageable);
    Page<Post> getPostByFoodFid(Long pno, String title,String content ,Pageable pageable);
    Page<Post> getPostBySights(Long pno, String title,String content ,Pageable pageable);
    Page<Post> getPostByAccomAid(Long pno, String title,String content ,Pageable pageable);

    void savePost(PostDTO postDTO);

    default  Post dtoToEntity(PostDTO dto){
        Post post =Post.builder()
                .pno(dto.getPno())
                .accom(dto.getAccom())
                .content(dto.getContent())
                .food(dto.getFood())
                .likeNum(dto.getLikeNum())
                .member(dto.getMember())
                .sights(dto.getSights())
                .title(dto.getTitle())
                .build();
        return post;
    }

    default PostDTO entityToDTO(Post post){
        PostDTO postDTO = PostDTO.builder()
                .pno(post.getPno())
                .title(post.getTitle())
                .sights(post.getSights())
                .member(post.getMember())
                .likeNum(post.getLikeNum())
                .food(post.getFood())
                .content(post.getContent())
                .accom(post.getAccom())
                .regDate(post.getRegDate())
                .modDate(post.getModDate())
                .build();
        return postDTO;

    }

    default PostCommentDTO entityToDTO(Post post , Member member, Long commentCnt){
        PostCommentDTO postCDTO = PostCommentDTO.builder()
                .pno(post.getPno())
                .title(post.getTitle())
                .sights(post.getSights())
                .member(post.getMember())
                .likeNum(post.getLikeNum())
                .food(post.getFood())
                .content(post.getContent())
                .accom(post.getAccom())
                .regDate(post.getRegDate())
                .modDate(post.getModDate())
                .memberEmail(member.getEmail())
                .commentCnt(commentCnt.intValue())
                .build();
        return postCDTO;

    }

}
