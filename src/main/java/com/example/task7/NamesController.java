package com.example.task7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class NamesController {
    //クライアントから/names宛の[nameのリストをください]というGetリクエストがサーバーに飛んできて、
    //GetMappingでリクエストを受け取り、リストを返す。クライアントとcontrollerだけのやり取り・・という認識で良いのでしょうか？
    @GetMapping("/names")
    public List<String> getName() {
        return List.of("koyama", "tanaka");
    }

    //下記の認識で合ってますでしょうか？ご確認お願い致します。
    //クライアントから/names宛の[リクエストボディの内容を登録してください]というPostリクエストがサーバーに飛んできて、
    //PostMappingでリクエストを受け取り、処理が成功したメッセージと、サーバーが付与したidが見られるURLを返す。

    //-ResponseEntity　httpレスポンスを表すクラスで、ステータスコード・レスポンスヘッダー＆ボディの情報が取得できる
    //-RequestBody リクエストボディをjson形式で受け取るもの
    //-UriComponentsBuilder URLを組み立てる
    //-fromUriString 引数を文字列にする
    //-ResponseEntity.created(url)でステータスコード201を作成
    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }
}
