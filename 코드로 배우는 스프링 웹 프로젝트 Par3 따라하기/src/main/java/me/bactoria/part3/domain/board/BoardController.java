package me.bactoria.part3.domain.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", boardService.getList());
    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {
        log.info("register: {}", board);
        boardService.register(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(Long bno, Model model) {
        log.info("get: {}", bno);
        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify: {}", board);
        if (boardService.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(Long bno, RedirectAttributes rttr) {
        log.info("delete: {}", bno);
        if(boardService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

}
