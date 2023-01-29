package com.example.task7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NamesController {
    //クライアントから/names宛の[nameのリストをください]というGetリクエストがサーバーに飛んできて、
    //GetMappingでリクエストを受け取り、リストを返す。クライアントとcontrollerだけのやり取り・・という認識で良いのでしょうか？
    @GetMapping("/names")
    public List<String> getName() {
        return List.of("koyama","tanaka");
    }
}
