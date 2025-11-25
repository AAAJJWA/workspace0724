package com.kh.spring.controller;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Member;
import com.kh.spring.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시글 목록 조회
    @GetMapping("list.bo")
    public String selectBoardList(@RequestParam(value = "cpage", defaultValue = "1") int cuurentPage, Model model) {
        Map<String, Object> result = boardService.getBoardList(cuurentPage);

        model.addAttribute("list", result.get("list"));
        model.addAttribute("pi",  result.get("pi"));

        return "board/listView";
    }

    @GetMapping("/enrollForm.bo")
    public String enrollForm(Model model) {
        List<Category> categories = boardService.getCategories();

        model.addAttribute("categories", categories);

        return "board/enrollForm";
    }

    //spring boot에는 spring-boot-starter-web의존을 추가하면
    @PostMapping("/insert.bo")
    public String insertBoard(Board board,
                              @RequestParam(value = "upfile", required = false) MultipartFile upfile,
                              HttpSession session) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        board.setBoardWriter(loginMember.getMemberNo());

        int result = boardService.insertBoard(board, upfile);

        return "redirect:/board/list.bo";
    }

    @PostMapping("/update.bo")
    public String updateBoard(Board board,
                              @RequestParam(value = "originFileNo", required = false) Integer originFileNo,
                              @RequestParam(value = "upfile", required = false) MultipartFile upfile,
                              HttpSession session, Model model) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        board.setBoardWriter(loginMember.getMemberNo());

        int result = boardService.updateBoard(board, upfile, originFileNo);

        if (result > 0) {
            // 성공 시 상세 페이지로 이동
            session.setAttribute("alertMsg", "게시글이 성공적으로 수정되었습니다.");
            return "redirect:/board/detail.bo?bno=" + board.getBoardNo();
        } else {
            // 실패 시 에러 페이지 or 수정 폼 복귀
            model.addAttribute("errorMsg", "게시글 수정에 실패했습니다.");
            return "common/errorPage";
        }
    }
}
