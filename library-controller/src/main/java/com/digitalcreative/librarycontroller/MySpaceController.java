package com.digitalcreative.librarycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MySpaceController {

    @GetMapping("/mySpace")
    public String mySpace(){
        return "mySpace";
    }

}
