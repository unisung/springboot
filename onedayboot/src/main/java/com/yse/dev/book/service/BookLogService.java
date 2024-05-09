package com.yse.dev.book.service;

import com.yse.dev.book.dto.BookLogCreateDTO;
import com.yse.dev.book.dto.BookLogCreateResponseDTO;

public interface BookLogService {
  public BookLogCreateResponseDTO 
          insert(BookLogCreateDTO bookLogCreateDTO);
}
