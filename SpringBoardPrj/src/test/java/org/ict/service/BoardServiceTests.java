package org.ict.service;

import static org.junit.Assert.assertNotNull;

import org.ict.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// Service 테스트는 BoardServiceImpl 내부 기능을
// 서버 가동 없이 테스트하기 위해 작성합니다.
// 아래에 기본 세팅을 해주세요.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	// 다형성 원리에 의해서 BoardService로 만들어도
	// BoardServiceImpl이 주입됨
	@Autowired
	private BoardService service;
	
	// 서비스가 제대로 주입되었는지 여부만 확인해봅니다.
	//@Test
	public void testExist() {
		log.info(service);
		// assertNotNull은 해당 객체가 주입이 되지 않아
		// null인 경우 에러를 발생시킵니다.
		assertNotNull(service);
	}
	
	//@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("Service Insert Test");
		vo.setContent("Service Insert Test");
		vo.setWriter("SIT");
		
		service.register(vo);
	}
	
	//@Test
	public void testGetList() {
		service.getList();
	}
	
	//@Test
	public void testGet() {
		service.get(8L);
	}
	
	//@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(7L);
		vo.setTitle("Service Update Test7");
		vo.setContent("Service Update Test7");
		vo.setWriter("Harry");
		
		service.modify(vo);
	}
	
	@Test
	public void testDelete() {
		service.remove(7L);
	}
}
