package com.yse.dev.book.service;


import java.util.List;
import java.util.NoSuchElementException;

import com.yse.dev.book.dto.BookCreateDTO;
import com.yse.dev.book.dto.BookEditDTO;
import com.yse.dev.book.dto.BookEditResponseDTO;
import com.yse.dev.book.dto.BookListResponseDTO;
import com.yse.dev.book.dto.BookReadResponseDTO;

public interface BookService {
   Integer insert(BookCreateDTO bookCreateDTO);
   public BookReadResponseDTO read(Integer bookId) 
		   throws NoSuchElementException;
   public BookEditResponseDTO edit(Integer bookId) 
		   throws NoSuchElementException;
   
   void update(BookEditDTO bookEditDTO)
		   throws NoSuchElementException;
   
   void delete(Integer bookId)
		   throws NoSuchElementException;
   
   public List<BookListResponseDTO> bookList(String title, Integer page);
}
