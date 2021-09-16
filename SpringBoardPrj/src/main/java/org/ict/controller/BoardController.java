package org.ict.controller;

import java.util.List;

import org.ict.domain.BoardVO;
import org.ict.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller //컨트롤러이므로 컨트롤러로 빈컨테이너에 컴포넌트 스캔
@Log4j //로깅 기능 추가
@RequestMapping("/board/*") //클래스 위에 작성시
//이 클래스를 사용하는 모든 메서드의 연결 주로 앞에 /board/ 추가
@AllArgsConstructor // 의존성 주입 설정을 위해 생성자만 생성
public class BoardController {
	
	// 컨트롤러는 서비스를 호출합니다. //서비스는 매퍼를 호출합니다.
	@Autowired
	private BoardService service;
	
	@GetMapping("/list") //Get방식으로만 주소연결
	public void list(Model model) {
		
		log.info("list로직 접속");
		List<BoardVO> boardList = service.getList();
		//view 파일에 list라는 이름으로 넘겨주기
		model.addAttribute("list", boardList);
	}
	
	//아래 주소로 데이터를 보내줄 수 있는 form을 작성해주세요.
	// register.jsp 파일명으로 작성해주시면 되고
	//@GetMapping으로 register.jsp에 접근할 수 있는
	//컨트롤러 메서드도 아래에 작성해주세요.
	
	@GetMapping("/register")
	public String register() {
		return "/board/register";
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, 
			RedirectAttributes rttr) {
		//글을 썼으면 상세페이지나 혹은 글목록으로 이동시켜야 합니다.
		//1. 글 쓰는 로직 실행후, 다시 목록을 DB에 꺼내온다음
		service.register(vo);
		

		//2. list 주소로 강제로 이동을 시킵니다.
		//addFlash는 redirect시에 컨트롤러에서
		//.jsp파일로 데이터를 보내줄 떄 사용합니다.
		//model.addAttritubte()를 쓴다면
		//일반 이동이 아닌 redirect 이동시는 데이터가 소실됩니다.
		//이를 막기 위해 rttr.addFlashAttribute로 대체합니다.
		rttr.addFlashAttribute("result", vo.getBno());
		
		// view폴더 하위 board 폴더의 list.jsp 출력
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		
		if(bno == null) {
			return "redirect:/board/list";
		}
		
		BoardVO vo = service.get(bno);
		
		model.addAttribute("board", vo);
		
		return "/board/get";
		
	}
}
