package org.ict.service;

import java.util.List;

import org.ict.domain.BoardVO;
import org.ict.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// BoardServiceImpl은 BoardService 인터페이스를 구현합니다.
@Log4j //로깅을 위한 어노테이션 //x가 뜨면 pom.xml에서 추가수정
@Service //의존성 등록을 위한 어노테이션
@AllArgsConstructor //서비스 생성자 자동생성
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	//등록 작업시 BoardVO를 매개로 실행하기 때문에
	//아래와 같이 BoardVO를 파라미터에 설정해둠.
	//BoardServiceTests에 VO를 생성해 테스트해주세요.
	@Override
	public void register(BoardVO vo) {
		
		log.info("등록 작업 실행");
		// mapper.insert(vo); 에서 bno를 얻기위해 변경
		mapper.insertSelectKey(vo);
		
	}

	//전체 글을 다 가져오는게 아닌 특정 글 하나만 가져오는 로직을
	//완성시켜주시고, 테스트코드도 작성해서 테스트해주세요.
	@Override
	public BoardVO get(Long bno) {
		return mapper.select(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		mapper.update(vo);
		
	}

	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
		
	}

	//글 전체 목록을 가져오는 로직을 작성해주세요.
	//해당 로직은 mapper 내부의 getList의 쿼리문을 먼저
	//전체 글을 가져오는 로직으로 수정해 주신 다음 service에
	//등록해서 구현해주시면 됩니다.
	//추가로 테스트도 진행해주세요.
	@Override
	public List<BoardVO> getList(String keyword) {
		log.info("전체 글 가져오기 실행 중");
		return mapper.getList(keyword);
	}

	
}
