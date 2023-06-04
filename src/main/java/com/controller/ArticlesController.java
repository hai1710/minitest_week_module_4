package com.controller;

import com.model.Articles;
import com.service.IArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class ArticlesController {
    @Autowired
    private IArticlesService articlesService;

    @GetMapping("")
    public ModelAndView showAll() {
        List<Articles> articlesList = articlesService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("articles", articlesList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView addArticle() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("article", new Articles());
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView save(@RequestParam String title, @RequestParam String content,
                              @RequestParam String created_date, RedirectAttributes redirectAttributes) {
        if (title != null && !title.isEmpty() && content != null && !content.isEmpty()) {
            int id = (int) (Math.random() * 1000);
            Articles articles = new Articles(id, title, content, LocalDate.parse(created_date));
            articlesService.save(articles);
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("success", "thêm mới thành công");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("create");
            redirectAttributes.addFlashAttribute("errorMessage", "thêm mới thất bại");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    private ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Articles article = articlesService.findById(id);
        modelAndView.addObject("article", article);
        modelAndView.addObject("title", article.getTitle()); // Định nghĩa giá trị cho thuộc tính 'title'
        modelAndView.addObject("content", article.getContent()); // Định nghĩa giá trị cho thuộc tính 'content'
        modelAndView.addObject("created_date", article.getCreated_date().toString()); // Định nghĩa giá trị cho thuộc tính 'created_date'
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    private ModelAndView update(@PathVariable int id,@RequestParam String title, @RequestParam String content, @RequestParam String created_date,  RedirectAttributes redirectAttributes){
        Articles article = articlesService.findById(id);
        article.setTitle(title);
        article.setContent(content);
        article.setCreated_date(LocalDate.parse(created_date));
        articlesService.edit(id,article);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("success", "sửa thành công");
        return modelAndView;
    }
    @PostMapping("/delete")
    private ModelAndView delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        articlesService.remote(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return modelAndView;
    }
}
