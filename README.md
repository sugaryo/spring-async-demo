# README

## これ is 何

`@Async` で使用するスレッドプール `ThreadPoolTaskExecutor` の検証プログラム。  
`ThreadPoolTaskExecutor` の設定値をいろいろ弄って動作検証。  
他にも `CachedThreadPool` とか実験する場合は **AsyncConfig の Bean定義実装** を弄って実験する。

## 実験方法

普通に SpringBootApplication として実行して `WSL2（Ubuntu）環境` から適当に `curl` 叩いて実験。  
Docker 好きなら JIB 使うなり、 SpringBoot の build-image 使うなりしてもろて。

## 実行ログ

[実験ノート](log.md) を参照。
