package org.ict.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

//기본 테스트 세팅을 어노테이션으로 해 주세요.


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
)// controller를 호출해야해서 둘 다 포함시켜야 함
@Log4j
@WebAppConfiguration //웹사이트 모의접속용 어노테이션
public class BoardControllerTests {

	// 아래 나오는 MockMvc를 만들기 위해 생성하는 객체
	@Autowired
	private WebApplicationContext ctx;
	
	//브라우저 없이 모의로 접속하는 기능을 가진 객체
	private MockMvc mockMvc;
	
	// @Test 이전에 실행할 내용을 기술하는 어노테이션
	// 주의! org.junit.before로 입력해주세요.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.
				webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testList() throws Exception {
		log.info(
			// .get(접속주소)/.post(접속주소) 를 제외한 나머지는
			// 다 고정된 양식을 가진 코드이므로 복잡해보이지만
			// 실제로는 복사붙여넣기로 쓰셔도 무방합니다.
			// .get(접속주소)를 입력하면 get방식으로 해당 주소에
			// 접속합니다.
			// /board/list에 접속하면 글 목록 가져오기 페이지이기 때문에
			// 글전체 목록을 가져오는지 여부를 테스트해야 합니다.
			mockMvc.perform(
			MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap()
			);
	}
	
	//@Test
	public void testRegister() throws Exception {
		
		String resultPage = mockMvc.perform(
			MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트코드제목")
				.param("content", "테스트코드본문")
				.param("writer", "테스트코드글쓴이")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	//@Test
	public void testGet() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/board/get")
				.param("bno", "13")
				).andReturn().getModelAndView().getViewName();
	}
	
	//@Test
	public void testRemove() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "10")
				).andReturn().getModelAndView().getViewName();
	}
	
	@Test
	public void testModify() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "30")
				.param("title", "수정완료1")
				.param("content", "수정이 완료되었습니다.1")
				.param("writer", "정수정")
				).andReturn().getModelAndView().getViewName();
	}
}
