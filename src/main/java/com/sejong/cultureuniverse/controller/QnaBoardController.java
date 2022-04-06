package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.service.QnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qnaboard")
@Log4j2
@RequiredArgsConstructor
public class QnaBoardController {
    private final QnaBoardService qnaBoardService;

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/admin/qnalist";
//    }
//    @GetMapping("/qnalist")
//    public void qnaList(PageRequestDTO pageRequestDTO, Model model){
//        log.info("qnalist"+pageRequestDTO);
//        model.addAttribute("result",qnaBoardService.getList(pageRequestDTO));
//    }
//    @GetMapping("/qnaread")
//    public void read(long questionIdx, Model model,
//                     @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO){
//        QnaBoardDTO dto = QnaBoardDTO
//       QnaBoardDTO dto = QnaBoardService.read(questionIdx);
//        model.addAttribute("dto",dto);
//    }
}
