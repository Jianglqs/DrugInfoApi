package com.api.latticy.service;

import com.api.latticy.model.BookDO;
import com.api.latticy.dto.book.CreateOrUpdateBookDTO;

import java.util.List;

/**
 * @author pedro@TaleLin
 */
public interface BookService {

    boolean createBook(CreateOrUpdateBookDTO validator);

    List<BookDO> getBookByKeyword(String q);

    boolean updateBook(BookDO book, CreateOrUpdateBookDTO validator);

    BookDO getById(Long id);

    List<BookDO> findAll();

    boolean deleteById(Long id);
}
