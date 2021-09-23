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
	public void list(Model model, String keyword) {
		
		if(keyword == null) {
			keyword = "";
		}
		
		log.info("list로직 접속");
		List<BoardVO> boardList = service.getList(keyword);
		//view 파일에 list라는 이름으로 넘겨주기
		model.addAttribute("list", boardList);
		model.addAttribute("keyword", keyword);
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
		rttr.addFlashAttribute("getBno", vo.getBno());
		rttr.addFlashAttribute("result", "register");
		
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
	
	//get방식으로 삭제를 허용하면 매크로 등을 이용해서
	//마음대로 글삭제를 하는 경우가 생길 수 있으므로
	//무조건 삭제 버튼을 클릭해서 삭제할 수 있도록
	//post방식 접근만 허용
	//bno를 받아서 삭제하고, 삭제 후에는 "success"라는 문자열을
	//.jsp로 보내줍니다.
	//삭제가 완료되면 redirect 기능을 이용해 list페이지로 넘어가게
	//코드 및 파라미터를 내부에 작성해주세요.
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		
		service.remove(bno);
		
		rttr.addFlashAttribute("result", "success");
		rttr.addFlashAttribute("bno", bno);
		
		//rttr.addFlashAttribute("<script>alert('글이 삭제되었습니다');</script>");
		return "redirect:/board/list";
	}
	
	//수정로직도 post방식으로 진행해야 합니다.
	// /modify를 주소로 하고, 사용자가 수정할 수 있는 요소들을
	// BoardVO로 받아서 수정한 다음 수정한 글의 디테일페이지로 
	// 넘어오면 됩니다.
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		
		service.modify(vo);
		
		//return "redirect:/board/get?bno=" + vo.getBno();\
		
		rttr.addFlashAttribute("bno", vo.getBno());
		
		return "redirect:/board/get";
	}
	
	//글을 수정할때는 modify.jsp를 이용해 수정을 해야합니다.
	//PostMapping을 이용해서 /boardmodify로 접속시 수정폼으로 접근시켜주세요.
	//수정 폼은 register.jsp와 비슷한 양식으로 작성되어 있지만
	//해당 글이 몇 번인지에 대한 정보도 화면에 표출시켜야 하고
	//글쓴이는 readonly를 걸어서 수정 불가하게 만들어주세요
	//아래 메서드는 수정 폼으로 접근하도록 만들어주시고
	//수정 폼에는 내가 수정하고자 하는 글의 정보를 먼저 받아온 다음
	//model.addAttribute로 정보를 .jsp로 보내서 폼을 채워주시면 됩니다.
	@PostMapping("/boardmodify")
	public String boardmodify(Long bno, Model model) {
		
		BoardVO vo = service.get(bno);
		
		model.addAttribute("board", vo);
		
		return "/board/boardmodify";
	}
	
}
