package com.iu.home.board.qna;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardFileDTO;
import com.iu.home.board.impl.BoardService;
import com.iu.home.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	
	public int setReply(QnaDTO qnaDTO)throws Exception {
		
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		
		return 0;
		
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		
		return qnaDAO.getList(pager);
	}
	
	

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO,MultipartFile[]files) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Insert 전 : "+boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert 후 : "+boardDTO.getNum());
		String realPath = servletContext.getRealPath("/resources/upload.qna");
		//폴더정보자바객체를선언
		File file = new File(realPath);
		//폴더생성
		if(! file.exists()) {
			file.mkdirs();
		}
		//중복되지 않는 파일 생성
		for(MultipartFile mf:files) {
			if(mf.isEmpty()) {
				continue;
			}
		//UUID 클래스 
		String fileName=UUID.randomUUID().toString();
		fileName = fileName+"-"+mf.getOriginalFilename();
		// HDD저장
		file = new File(file, fileName);
		mf.transferTo(file);
		
		//저장하는 코드
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(mf.getOriginalFilename());
		boardFileDTO.setNum(boardDTO.getNum());
		qnaDAO.setAddFile(boardFileDTO);
		}
		
		return result;
		
		}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}
	
	

}
