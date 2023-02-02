package com.example.task7;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NamesController {
    //クライアントから/names宛の[nameのリストをください]というGetリクエストがサーバーに飛んできて、
    //GetMappingでリクエストを受け取り、リストを返す。クライアントとcontrollerだけのやり取り・・という認識で良いのでしょうか？
    @GetMapping("/names")
    public List<String> getName() {
        return List.of("koyama", "tanaka");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("massage", "name successfully updated"));
    }
}
