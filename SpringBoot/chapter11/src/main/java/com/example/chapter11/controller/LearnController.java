package com.example.chapter11.controller;

import com.example.chapter11.domain.LearnResource;
import com.example.chapter11.service.LearnService;
import com.example.chapter11.util.AjaxObject;
import com.example.chapter11.model.LeanQueryLeanListReq;
import com.example.chapter11.util.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/learn")
public class LearnController extends AbstractController {
    @Autowired
    private LearnService learnService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(Model model){
        model.addAttribute("ctx", getContextPath() + "/");
        return "learn-resource";

    }


    @RequestMapping(value = "/queryLeanList", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject queryLearnList(Page<LeanQueryLeanListReq> page){
        List<LearnResource> learnList = learnService.queryLearnResouceList(page);
        PageInfo<LearnResource> pageInfo = new PageInfo<>(learnList);
        return AjaxObject.ok().put("page", pageInfo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addLearn(@RequestBody LearnResource learn){
        learnService.save(learn);
        return AjaxObject.ok();
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject updateLearn(@RequestBody LearnResource lean){
        learnService.updateNotNull(lean);
        return AjaxObject.ok();
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject deleteLearn(@RequestBody Long[] ids){
        learnService.deleteBatch(ids);
        return AjaxObject.ok();
    }




}
