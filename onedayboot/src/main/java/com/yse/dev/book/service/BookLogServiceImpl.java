package com.yse.dev.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yse.dev.book.dto.BookLogCreateDTO;
import com.yse.dev.book.dto.BookLogCreateResponseDTO;
import com.yse.dev.book.entity.Book;
import com.yse.dev.book.entity.BookLog;
import com.yse.dev.book.entity.BookLogRepository;
import com.yse.dev.book.entity.BookRepository;

@Service
public class BookLogServiceImpl implements BookLogService{
	@Autowired
	private BookRepository bookRepository;  
    @Autowired
	private BookLogRepository bookLogRepository; 
    
    
	@Override
	public BookLogCreateResponseDTO insert(BookLogCreateDTO bookLogCreateDTO) {
		Book book = bookRepository.findById(bookLogCreateDTO.getBookId()).orElseThrow();  

        BookLog bookLog = BookLog.builder()  
            .book(book)  
            .comment(bookLogCreateDTO.getComment())  
            .page(bookLogCreateDTO.getPage())  
            .build();  

        bookLog = bookLogRepository.save(bookLog);  
        return BookLogCreateResponseDTO.BookLogFactory(bookLog);
	}

}
