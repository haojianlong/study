package com.study.study.controller;

import com.study.study.entity.CompanyType;
import com.study.study.enums.ResponseCodeEnum;
import com.study.study.repository.CompanyTypeRepository;
import com.study.study.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CompanyTypeController {

    @Autowired
    private CompanyTypeRepository companyTypeRepository;

    @GetMapping(value = "/companyType")
    public Response companyTypeList() {
        System.out.println("ttttttttt");
        return Response.render(ResponseCodeEnum.SUCCESS, companyTypeRepository.findAll());
    }

    @GetMapping(value = "/name")
    public String companyTypeName() {
        List<CompanyType> arr = companyTypeRepository.findAll();
        String str = "";

        for (CompanyType object : arr) {
            str += " " + object.getName();
        }

        return str;
    }

    /**
     * @param type
     * @return
     */
    @PostMapping(value = "/type/{id}")
    public Response type(@Valid CompanyType type, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<String, String>();
            for (ObjectError error : bindingResult.getFieldErrors()) {
                map.put(error.getObjectName(), error.getDefaultMessage());
            }
            return Response.render(ResponseCodeEnum.VALIDATE_FAILURE, map);
        }
        return Response.render(ResponseCodeEnum.SUCCESS, companyTypeRepository.save(type));
    }

}
