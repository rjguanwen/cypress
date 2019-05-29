package cn.rjguanwen.cypress.booklibrary.controller;

import cn.rjguanwen.booklib.entity.Book;
import cn.rjguanwen.booklib.service.BookService;
import cn.rjguanwen.booklib.util.CommonResult.Result;
import cn.rjguanwen.booklib.util.CommonResult.StatusConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: BookController
 * @Description: TODO
 * @Author: 郑斌
 * @Date: 2019/5/5 19:26
 **/
@RestController
@RequestMapping("/v1/book")
@Api(tags="书籍API")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value="查询所有书籍")
    @RequestMapping(value="/getAllBooks", method=RequestMethod.GET)
    public List<Book> getBookListAll(){
        return bookService.getAllBooks();
    }

    @ApiOperation(value="按页查询书籍")
    @RequestMapping(value="/getBooksInPage", method=RequestMethod.GET)
    public Object getBooksInPage(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order
    ){
        //分页
        PageHelper.offsetPage(offset, limit);
//        PageHelper.startPage(1, 10);
        List<Book> list = bookService.getAllBooks();
        PageInfo page = new PageInfo(list);
        return new Result(StatusConstants.SUCCESS, "分页查询成功！",page);
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value="根据ID查询书籍", notes = "查询数据库中书籍详细信息")
    @ApiImplicitParam(name="id", value="书籍id", required=true)
    public Object getBook(@PathVariable int id){
        Book book = bookService.getBook(id);
        return new Result(StatusConstants.SUCCESS, "查询书籍成功！", book);
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public Object insertBook(@RequestBody Book book){
        int i = bookService.insertBook(book);
        return new Result(StatusConstants.SUCCESS, "书籍插入成功！");
    }

    @PostMapping(value = "/update")
    public Object updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return new Result(StatusConstants.SUCCESS, "书籍信息修改成功！");
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    public Object deleteBook( @PathVariable("id") int id) {
        bookService.deleteBook(id);
        return new Result(StatusConstants.SUCCESS, "书籍删除成功！");
    }
}
