# 実験ノート

## threadpool1 の実行ログ

|threadpool1|設定値|
|----|--|
|CorePoolSize|2|
|MaxPoolSize|4|
|QueueCapacity|0|

- Ubuntu で curl 15 連打

```log
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 543d55d5-a4f6-4762-b20f-a2205e8899eb
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > cffeaf5c-710f-44f2-b8ec-9777335ea5a1
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 045a1123-ef76-47c3-bd58-9689c66797de
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 9b451f60-0b01-41d1-b1ac-3d8333efc06f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 1380221b-a4d1-42f7-86f4-a5ba5644c254
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > b9a31114-59cc-4d45-9996-9a869b284935
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > fdf3f81d-ecde-4980-be70-03a36bd9c1bc
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > a58dcb7d-e22f-48a8-bbbc-7518ce7741ef
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > ebb3a63d-9447-4afb-a51d-50f899af3585
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 6ad7dbdf-42ad-4ab0-a289-20a8d95af614
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > c9bd8a03-a41b-4c6b-98d1-498d00e7332a
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > f83cfcb2-8fc2-4e06-b5c4-b28c857dff6f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 54981e94-40ec-456d-8649-5628d716c218
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 06b28c67-86b3-403b-9662-67732a5edf87
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
```

- SpringBootApplication側 のログ出力

```log
2021-05-18 21:49:39.880  INFO 3580 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[543d55d5-a4f6-4762-b20f-a2205e8899eb] requested.
2021-05-18 21:49:39.904  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[543d55d5-a4f6-4762-b20f-a2205e8899eb] doing.
2021-05-18 21:49:40.094  INFO 3580 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[cffeaf5c-710f-44f2-b8ec-9777335ea5a1] requested.
2021-05-18 21:49:40.095  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[cffeaf5c-710f-44f2-b8ec-9777335ea5a1] doing.
2021-05-18 21:49:40.358  INFO 3580 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[045a1123-ef76-47c3-bd58-9689c66797de] requested.
2021-05-18 21:49:40.621  INFO 3580 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[9b451f60-0b01-41d1-b1ac-3d8333efc06f] requested.
2021-05-18 21:49:40.885  INFO 3580 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[1380221b-a4d1-42f7-86f4-a5ba5644c254] requested.
2021-05-18 21:49:41.164  INFO 3580 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[b9a31114-59cc-4d45-9996-9a869b284935] requested.
2021-05-18 21:49:41.405  INFO 3580 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[fdf3f81d-ecde-4980-be70-03a36bd9c1bc] requested.
2021-05-18 21:49:41.701  INFO 3580 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[a58dcb7d-e22f-48a8-bbbc-7518ce7741ef] requested.
2021-05-18 21:49:41.927  INFO 3580 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[ebb3a63d-9447-4afb-a51d-50f899af3585] requested.
2021-05-18 21:49:42.203  INFO 3580 --- [io-8899-exec-10] sugaryo.demo.async.app.TaskController    : ■ task[6ad7dbdf-42ad-4ab0-a289-20a8d95af614] requested.
2021-05-18 21:49:42.445  INFO 3580 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[c9bd8a03-a41b-4c6b-98d1-498d00e7332a] requested.
2021-05-18 21:49:42.727  INFO 3580 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[f83cfcb2-8fc2-4e06-b5c4-b28c857dff6f] requested.
2021-05-18 21:49:42.956  INFO 3580 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[54981e94-40ec-456d-8649-5628d716c218] requested.
2021-05-18 21:49:42.957  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[54981e94-40ec-456d-8649-5628d716c218] doing.
2021-05-18 21:49:43.215  INFO 3580 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[06b28c67-86b3-403b-9662-67732a5edf87] requested.
2021-05-18 21:49:43.215  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[06b28c67-86b3-403b-9662-67732a5edf87] doing.
2021-05-18 21:49:43.493  INFO 3580 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[3b1480ac-3df0-4aaa-801e-541463a18617] requested.
2021-05-18 21:49:43.501  WARN 3580 --- [nio-8899-exec-5] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@79c14a2e[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 0]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x0000000800493b30@38fc4015]
2021-05-18 21:49:49.907  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[543d55d5-a4f6-4762-b20f-a2205e8899eb] done.
2021-05-18 21:49:49.907  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[045a1123-ef76-47c3-bd58-9689c66797de] doing.
2021-05-18 21:49:50.111  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[cffeaf5c-710f-44f2-b8ec-9777335ea5a1] done.
2021-05-18 21:49:50.111  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[9b451f60-0b01-41d1-b1ac-3d8333efc06f] doing.
2021-05-18 21:49:52.965  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[54981e94-40ec-456d-8649-5628d716c218] done.
2021-05-18 21:49:52.965  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[1380221b-a4d1-42f7-86f4-a5ba5644c254] doing.
2021-05-18 21:49:53.218  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[06b28c67-86b3-403b-9662-67732a5edf87] done.
2021-05-18 21:49:53.218  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[b9a31114-59cc-4d45-9996-9a869b284935] doing.
2021-05-18 21:49:59.923  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[045a1123-ef76-47c3-bd58-9689c66797de] done.
2021-05-18 21:49:59.923  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[fdf3f81d-ecde-4980-be70-03a36bd9c1bc] doing.
2021-05-18 21:50:00.113  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[9b451f60-0b01-41d1-b1ac-3d8333efc06f] done.
2021-05-18 21:50:00.113  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[a58dcb7d-e22f-48a8-bbbc-7518ce7741ef] doing.
2021-05-18 21:50:02.978  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[1380221b-a4d1-42f7-86f4-a5ba5644c254] done.
2021-05-18 21:50:02.979  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[ebb3a63d-9447-4afb-a51d-50f899af3585] doing.
2021-05-18 21:50:03.227  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[b9a31114-59cc-4d45-9996-9a869b284935] done.
2021-05-18 21:50:03.227  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[6ad7dbdf-42ad-4ab0-a289-20a8d95af614] doing.
2021-05-18 21:50:09.931  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[fdf3f81d-ecde-4980-be70-03a36bd9c1bc] done.
2021-05-18 21:50:09.931  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[c9bd8a03-a41b-4c6b-98d1-498d00e7332a] doing.
2021-05-18 21:50:10.120  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[a58dcb7d-e22f-48a8-bbbc-7518ce7741ef] done.
2021-05-18 21:50:10.121  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[f83cfcb2-8fc2-4e06-b5c4-b28c857dff6f] doing.
2021-05-18 21:50:12.980  INFO 3580 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[ebb3a63d-9447-4afb-a51d-50f899af3585] done.
2021-05-18 21:50:13.232  INFO 3580 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[6ad7dbdf-42ad-4ab0-a289-20a8d95af614] done.
2021-05-18 21:50:19.938  INFO 3580 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[c9bd8a03-a41b-4c6b-98d1-498d00e7332a] done.
2021-05-18 21:50:20.127  INFO 3580 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[f83cfcb2-8fc2-4e06-b5c4-b28c857dff6f] done.
```

## threadppol1 で再度実行ログをとる

ちょっと上の結果が気になったので再度実行。

- Ubuntu で curl 連打

```log
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > d60eece0-3faa-4e3b-965e-2fc6880aece6
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > fe69cc65-fd23-4d88-9d4d-00fa819030d0
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 0304190a-b082-4ef3-ab5f-5d8439534ce1
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > c4b9b3ae-0bb5-4355-9ea7-5d0ce3c99d3a
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > bf8d2f68-0170-4833-a98c-e680553f9725
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 277a9d9e-ef87-49a3-b6dc-60d510a9de1d
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 37d92744-d2e4-4654-a371-049a4b95b170
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 5be6708d-55e9-4187-93bc-05fe707ea637
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 1fd07ed2-7310-4574-a187-9b9b0655f89b
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 49d2276b-d306-4b7a-8b28-c40fe8448819
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 87eb0c91-e3b5-4532-aceb-8a7a8daf74f8
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 878296bc-b958-41ef-92f5-21c4a0fa9902
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > b533e272-50d7-4b67-988a-c84d1489f5b5
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > e7466a22-d978-4555-ac6f-9f11d66007a7
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
# too busy を確認して一旦ここで休憩、先行したタスクが完了したのを確認して連打再開。
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > d860aaa0-7a00-45c2-939b-4ce81b6aad42
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 7c94ce46-10a0-4e9f-b63c-012556b106ff
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
```

- SpringBootApplication側 のログ出力

```log
2021-05-18 21:58:23.908  INFO 14040 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[d60eece0-3faa-4e3b-965e-2fc6880aece6] requested.
2021-05-18 21:58:23.928  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[d60eece0-3faa-4e3b-965e-2fc6880aece6] doing.
2021-05-18 21:58:24.088  INFO 14040 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[fe69cc65-fd23-4d88-9d4d-00fa819030d0] requested.
2021-05-18 21:58:24.089  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[fe69cc65-fd23-4d88-9d4d-00fa819030d0] doing.
2021-05-18 21:58:24.297  INFO 14040 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[0304190a-b082-4ef3-ab5f-5d8439534ce1] requested.
2021-05-18 21:58:24.493  INFO 14040 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[c4b9b3ae-0bb5-4355-9ea7-5d0ce3c99d3a] requested.
2021-05-18 21:58:24.686  INFO 14040 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[bf8d2f68-0170-4833-a98c-e680553f9725] requested.
2021-05-18 21:58:24.893  INFO 14040 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[277a9d9e-ef87-49a3-b6dc-60d510a9de1d] requested.
2021-05-18 21:58:25.133  INFO 14040 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[37d92744-d2e4-4654-a371-049a4b95b170] requested.
2021-05-18 21:58:25.357  INFO 14040 --- [io-8899-exec-10] sugaryo.demo.async.app.TaskController    : ■ task[5be6708d-55e9-4187-93bc-05fe707ea637] requested.
2021-05-18 21:58:25.581  INFO 14040 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[1fd07ed2-7310-4574-a187-9b9b0655f89b] requested.
2021-05-18 21:58:25.769  INFO 14040 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[49d2276b-d306-4b7a-8b28-c40fe8448819] requested.
2021-05-18 21:58:26.014  INFO 14040 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[87eb0c91-e3b5-4532-aceb-8a7a8daf74f8] requested.
2021-05-18 21:58:26.184  INFO 14040 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[878296bc-b958-41ef-92f5-21c4a0fa9902] requested.
2021-05-18 21:58:26.398  INFO 14040 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[b533e272-50d7-4b67-988a-c84d1489f5b5] requested.
2021-05-18 21:58:26.399  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[b533e272-50d7-4b67-988a-c84d1489f5b5] doing.
2021-05-18 21:58:26.635  INFO 14040 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[e7466a22-d978-4555-ac6f-9f11d66007a7] requested.
2021-05-18 21:58:26.636  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[e7466a22-d978-4555-ac6f-9f11d66007a7] doing.
2021-05-18 21:58:26.926  INFO 14040 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[4806e902-cd2b-44a7-a5c5-c4dcba15dbdf] requested.
2021-05-18 21:58:26.931  WARN 14040 --- [nio-8899-exec-9] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@5db9e09d[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 0]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x00000008004938f0@1c84eaa6]
2021-05-18 21:58:27.141  INFO 14040 --- [io-8899-exec-10] sugaryo.demo.async.app.TaskController    : ■ task[2ffe5bff-bf5e-4b0c-92be-34265cd2f70d] requested.
2021-05-18 21:58:27.143  WARN 14040 --- [io-8899-exec-10] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@5db9e09d[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 0]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x00000008004938f0@283291fc]
2021-05-18 21:58:33.935  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[d60eece0-3faa-4e3b-965e-2fc6880aece6] done.
2021-05-18 21:58:33.936  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[0304190a-b082-4ef3-ab5f-5d8439534ce1] doing.
2021-05-18 21:58:34.092  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[fe69cc65-fd23-4d88-9d4d-00fa819030d0] done.
2021-05-18 21:58:34.092  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[c4b9b3ae-0bb5-4355-9ea7-5d0ce3c99d3a] doing.
2021-05-18 21:58:35.286  INFO 14040 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[d860aaa0-7a00-45c2-939b-4ce81b6aad42] requested.
2021-05-18 21:58:35.559  INFO 14040 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[7c94ce46-10a0-4e9f-b63c-012556b106ff] requested.
2021-05-18 21:58:35.765  INFO 14040 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[f4b3118d-6053-41ef-8cec-8924496bc2eb] requested.
2021-05-18 21:58:35.767  WARN 14040 --- [nio-8899-exec-4] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@5db9e09d[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 2]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x00000008004938f0@60e0de67]
2021-05-18 21:58:35.973  INFO 14040 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[105dad32-ef8a-4453-8dda-fd73b7907daa] requested.
2021-05-18 21:58:35.974  WARN 14040 --- [nio-8899-exec-5] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@5db9e09d[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 2]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x00000008004938f0@5542d053]
2021-05-18 21:58:36.237  INFO 14040 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[7bbfee36-80f4-44ba-8da1-69ec040a4a4f] requested.
2021-05-18 21:58:36.239  WARN 14040 --- [nio-8899-exec-6] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@5db9e09d[Running, pool size = 4, active threads = 4, queued tasks = 10, completed tasks = 2]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x00000008004938f0@25f87454]
2021-05-18 21:58:36.407  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[b533e272-50d7-4b67-988a-c84d1489f5b5] done.
2021-05-18 21:58:36.407  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[bf8d2f68-0170-4833-a98c-e680553f9725] doing.
2021-05-18 21:58:36.646  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[e7466a22-d978-4555-ac6f-9f11d66007a7] done.
2021-05-18 21:58:36.646  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[277a9d9e-ef87-49a3-b6dc-60d510a9de1d] doing.
2021-05-18 21:58:43.942  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[0304190a-b082-4ef3-ab5f-5d8439534ce1] done.
2021-05-18 21:58:43.942  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[37d92744-d2e4-4654-a371-049a4b95b170] doing.
2021-05-18 21:58:44.100  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[c4b9b3ae-0bb5-4355-9ea7-5d0ce3c99d3a] done.
2021-05-18 21:58:44.100  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[5be6708d-55e9-4187-93bc-05fe707ea637] doing.
2021-05-18 21:58:46.420  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[bf8d2f68-0170-4833-a98c-e680553f9725] done.
2021-05-18 21:58:46.422  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[1fd07ed2-7310-4574-a187-9b9b0655f89b] doing.
2021-05-18 21:58:46.653  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[277a9d9e-ef87-49a3-b6dc-60d510a9de1d] done.
2021-05-18 21:58:46.653  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[49d2276b-d306-4b7a-8b28-c40fe8448819] doing.
2021-05-18 21:58:53.945  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[37d92744-d2e4-4654-a371-049a4b95b170] done.
2021-05-18 21:58:53.945  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▼ task[87eb0c91-e3b5-4532-aceb-8a7a8daf74f8] doing.
2021-05-18 21:58:54.106  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[5be6708d-55e9-4187-93bc-05fe707ea637] done.
2021-05-18 21:58:54.107  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▼ task[878296bc-b958-41ef-92f5-21c4a0fa9902] doing.
2021-05-18 21:58:56.428  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[1fd07ed2-7310-4574-a187-9b9b0655f89b] done.
2021-05-18 21:58:56.428  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▼ task[d860aaa0-7a00-45c2-939b-4ce81b6aad42] doing.
2021-05-18 21:58:56.665  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[49d2276b-d306-4b7a-8b28-c40fe8448819] done.
2021-05-18 21:58:56.665  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▼ task[7c94ce46-10a0-4e9f-b63c-012556b106ff] doing.
2021-05-18 21:59:03.950  INFO 14040 --- [        pool1-1] sugaryo.demo.async.app.TaskModule        : ▲ task[87eb0c91-e3b5-4532-aceb-8a7a8daf74f8] done.
2021-05-18 21:59:04.110  INFO 14040 --- [        pool1-2] sugaryo.demo.async.app.TaskModule        : ▲ task[878296bc-b958-41ef-92f5-21c4a0fa9902] done.
2021-05-18 21:59:06.439  INFO 14040 --- [        pool1-3] sugaryo.demo.async.app.TaskModule        : ▲ task[d860aaa0-7a00-45c2-939b-4ce81b6aad42] done.
2021-05-18 21:59:06.678  INFO 14040 --- [        pool1-4] sugaryo.demo.async.app.TaskModule        : ▲ task[7c94ce46-10a0-4e9f-b63c-012556b106ff] done.
```

## threadpool2 の実行ログ

|threadpool2|設定値|
|----|--|
|CorePoolSize|4|
|MaxPoolSize|500|
|QueueCapacity|1|

- 適当に curl を連打。

```log
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 8a42f41f-d876-45fe-8fd4-40470b6db33b
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > cab1ef97-6788-42b5-b18e-8d7e296cfe66
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 3e31e475-10fe-43b6-8dff-c256251e75d0
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 43fc7078-2f90-4e3c-97b3-9aadd23117eb
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 4523f975-b5fd-43d4-812f-223a141b86dd
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 81874b54-e1ba-485b-a43c-a17dcbf79084
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > a5369902-423d-4bc7-b517-ce6ddb684d0f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 80fa1be9-833a-44b6-a668-5e1e0fc66604
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 709b016e-4de7-44a5-98ba-dbe4f724f2ca
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 4b3caee3-0260-4ed6-b7be-70e486e5e106
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 0efe6743-8045-4751-b879-a8bf37fe7326
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > dfe9bdec-cf4f-4799-a06e-e231fc229099
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 4604b965-9c25-44a1-8f70-58085817c7bf
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 55a540a7-f28c-4228-a1f7-b18b69c6154e
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 86b52a1c-adae-4588-b8c1-580e2e8ed5ca
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 65007395-9e0d-4a5f-9352-e3d2e365ec8e
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 5667e7f1-6358-492a-a16e-e758a70f859f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > f3317272-1d3c-4c42-8a7e-ad5f77e09794
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 01193aa1-d0e6-4396-b445-6abb831d5db8
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > a20d9f7e-8cc0-4f2a-bfbe-b0a56b425b4f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 000f9540-21ae-4788-8254-e59ff5b7f895
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > da13fb6e-5b49-41c6-8c50-e7d64b5fb8a9
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > b725e0e1-f4c8-4ff4-b60f-686203b176a5
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 7ceefd02-5a00-4702-9cfb-5756a24ffd8e
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 94716969-7668-4c66-b12f-472feffaee21
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 86116c41-4e58-48ca-98ca-309930b8f764
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > a0c42282-5c57-4466-94b3-349139c04a64
```

- SpringBootApplication側 のログ出力

```log
2021-05-18 22:03:32.570  INFO 8156 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[8a42f41f-d876-45fe-8fd4-40470b6db33b] requested.
2021-05-18 22:03:32.597  INFO 8156 --- [        pool2-1] sugaryo.demo.async.app.TaskModule        : ▼ task[8a42f41f-d876-45fe-8fd4-40470b6db33b] doing.
2021-05-18 22:03:32.743  INFO 8156 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[cab1ef97-6788-42b5-b18e-8d7e296cfe66] requested.
2021-05-18 22:03:32.744  INFO 8156 --- [        pool2-2] sugaryo.demo.async.app.TaskModule        : ▼ task[cab1ef97-6788-42b5-b18e-8d7e296cfe66] doing.
2021-05-18 22:03:32.967  INFO 8156 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[3e31e475-10fe-43b6-8dff-c256251e75d0] requested.
2021-05-18 22:03:32.968  INFO 8156 --- [        pool2-3] sugaryo.demo.async.app.TaskModule        : ▼ task[3e31e475-10fe-43b6-8dff-c256251e75d0] doing.
2021-05-18 22:03:33.188  INFO 8156 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[43fc7078-2f90-4e3c-97b3-9aadd23117eb] requested.
2021-05-18 22:03:33.189  INFO 8156 --- [        pool2-4] sugaryo.demo.async.app.TaskModule        : ▼ task[43fc7078-2f90-4e3c-97b3-9aadd23117eb] doing.
2021-05-18 22:03:33.414  INFO 8156 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[4523f975-b5fd-43d4-812f-223a141b86dd] requested.
2021-05-18 22:03:33.655  INFO 8156 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[81874b54-e1ba-485b-a43c-a17dcbf79084] requested.
2021-05-18 22:03:33.655  INFO 8156 --- [        pool2-5] sugaryo.demo.async.app.TaskModule        : ▼ task[81874b54-e1ba-485b-a43c-a17dcbf79084] doing.
2021-05-18 22:03:33.904  INFO 8156 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[a5369902-423d-4bc7-b517-ce6ddb684d0f] requested.
2021-05-18 22:03:33.905  INFO 8156 --- [        pool2-6] sugaryo.demo.async.app.TaskModule        : ▼ task[a5369902-423d-4bc7-b517-ce6ddb684d0f] doing.
2021-05-18 22:03:34.159  INFO 8156 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[80fa1be9-833a-44b6-a668-5e1e0fc66604] requested.
2021-05-18 22:03:34.160  INFO 8156 --- [        pool2-7] sugaryo.demo.async.app.TaskModule        : ▼ task[80fa1be9-833a-44b6-a668-5e1e0fc66604] doing.
2021-05-18 22:03:34.367  INFO 8156 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[709b016e-4de7-44a5-98ba-dbe4f724f2ca] requested.
2021-05-18 22:03:34.367  INFO 8156 --- [        pool2-8] sugaryo.demo.async.app.TaskModule        : ▼ task[709b016e-4de7-44a5-98ba-dbe4f724f2ca] doing.
2021-05-18 22:03:34.620  INFO 8156 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[4b3caee3-0260-4ed6-b7be-70e486e5e106] requested.
2021-05-18 22:03:34.621  INFO 8156 --- [        pool2-9] sugaryo.demo.async.app.TaskModule        : ▼ task[4b3caee3-0260-4ed6-b7be-70e486e5e106] doing.
2021-05-18 22:03:35.125  INFO 8156 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[0efe6743-8045-4751-b879-a8bf37fe7326] requested.
2021-05-18 22:03:35.126  INFO 8156 --- [       pool2-10] sugaryo.demo.async.app.TaskModule        : ▼ task[0efe6743-8045-4751-b879-a8bf37fe7326] doing.
2021-05-18 22:03:35.429  INFO 8156 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[dfe9bdec-cf4f-4799-a06e-e231fc229099] requested.
2021-05-18 22:03:35.430  INFO 8156 --- [       pool2-11] sugaryo.demo.async.app.TaskModule        : ▼ task[dfe9bdec-cf4f-4799-a06e-e231fc229099] doing.
2021-05-18 22:03:35.638  INFO 8156 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[4604b965-9c25-44a1-8f70-58085817c7bf] requested.
2021-05-18 22:03:35.639  INFO 8156 --- [       pool2-12] sugaryo.demo.async.app.TaskModule        : ▼ task[4604b965-9c25-44a1-8f70-58085817c7bf] doing.
2021-05-18 22:03:35.808  INFO 8156 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[55a540a7-f28c-4228-a1f7-b18b69c6154e] requested.
2021-05-18 22:03:35.809  INFO 8156 --- [       pool2-13] sugaryo.demo.async.app.TaskModule        : ▼ task[55a540a7-f28c-4228-a1f7-b18b69c6154e] doing.
2021-05-18 22:03:35.974  INFO 8156 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[86b52a1c-adae-4588-b8c1-580e2e8ed5ca] requested.
2021-05-18 22:03:35.976  INFO 8156 --- [       pool2-14] sugaryo.demo.async.app.TaskModule        : ▼ task[86b52a1c-adae-4588-b8c1-580e2e8ed5ca] doing.
2021-05-18 22:03:36.167  INFO 8156 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[65007395-9e0d-4a5f-9352-e3d2e365ec8e] requested.
2021-05-18 22:03:36.176  INFO 8156 --- [       pool2-15] sugaryo.demo.async.app.TaskModule        : ▼ task[65007395-9e0d-4a5f-9352-e3d2e365ec8e] doing.
2021-05-18 22:03:36.311  INFO 8156 --- [io-8899-exec-10] sugaryo.demo.async.app.TaskController    : ■ task[5667e7f1-6358-492a-a16e-e758a70f859f] requested.
2021-05-18 22:03:36.312  INFO 8156 --- [       pool2-16] sugaryo.demo.async.app.TaskModule        : ▼ task[5667e7f1-6358-492a-a16e-e758a70f859f] doing.
2021-05-18 22:03:36.480  INFO 8156 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[f3317272-1d3c-4c42-8a7e-ad5f77e09794] requested.
2021-05-18 22:03:36.481  INFO 8156 --- [       pool2-17] sugaryo.demo.async.app.TaskModule        : ▼ task[f3317272-1d3c-4c42-8a7e-ad5f77e09794] doing.
2021-05-18 22:03:36.648  INFO 8156 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[01193aa1-d0e6-4396-b445-6abb831d5db8] requested.
2021-05-18 22:03:36.650  INFO 8156 --- [       pool2-18] sugaryo.demo.async.app.TaskModule        : ▼ task[01193aa1-d0e6-4396-b445-6abb831d5db8] doing.
2021-05-18 22:03:36.819  INFO 8156 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[a20d9f7e-8cc0-4f2a-bfbe-b0a56b425b4f] requested.
2021-05-18 22:03:36.823  INFO 8156 --- [       pool2-19] sugaryo.demo.async.app.TaskModule        : ▼ task[a20d9f7e-8cc0-4f2a-bfbe-b0a56b425b4f] doing.
2021-05-18 22:03:36.985  INFO 8156 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[000f9540-21ae-4788-8254-e59ff5b7f895] requested.
2021-05-18 22:03:36.986  INFO 8156 --- [       pool2-20] sugaryo.demo.async.app.TaskModule        : ▼ task[000f9540-21ae-4788-8254-e59ff5b7f895] doing.
2021-05-18 22:03:37.143  INFO 8156 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[da13fb6e-5b49-41c6-8c50-e7d64b5fb8a9] requested.
2021-05-18 22:03:37.144  INFO 8156 --- [       pool2-21] sugaryo.demo.async.app.TaskModule        : ▼ task[da13fb6e-5b49-41c6-8c50-e7d64b5fb8a9] doing.
2021-05-18 22:03:37.319  INFO 8156 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[b725e0e1-f4c8-4ff4-b60f-686203b176a5] requested.
2021-05-18 22:03:37.322  INFO 8156 --- [       pool2-22] sugaryo.demo.async.app.TaskModule        : ▼ task[b725e0e1-f4c8-4ff4-b60f-686203b176a5] doing.
2021-05-18 22:03:37.487  INFO 8156 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[7ceefd02-5a00-4702-9cfb-5756a24ffd8e] requested.
2021-05-18 22:03:37.488  INFO 8156 --- [       pool2-23] sugaryo.demo.async.app.TaskModule        : ▼ task[7ceefd02-5a00-4702-9cfb-5756a24ffd8e] doing.
2021-05-18 22:03:37.669  INFO 8156 --- [io-8899-exec-10] sugaryo.demo.async.app.TaskController    : ■ task[94716969-7668-4c66-b12f-472feffaee21] requested.
2021-05-18 22:03:37.670  INFO 8156 --- [       pool2-24] sugaryo.demo.async.app.TaskModule        : ▼ task[94716969-7668-4c66-b12f-472feffaee21] doing.
2021-05-18 22:03:37.838  INFO 8156 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[86116c41-4e58-48ca-98ca-309930b8f764] requested.
2021-05-18 22:03:37.842  INFO 8156 --- [       pool2-25] sugaryo.demo.async.app.TaskModule        : ▼ task[86116c41-4e58-48ca-98ca-309930b8f764] doing.
2021-05-18 22:03:38.004  INFO 8156 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[a0c42282-5c57-4466-94b3-349139c04a64] requested.
2021-05-18 22:03:38.005  INFO 8156 --- [       pool2-26] sugaryo.demo.async.app.TaskModule        : ▼ task[a0c42282-5c57-4466-94b3-349139c04a64] doing.
2021-05-18 22:03:42.614  INFO 8156 --- [        pool2-1] sugaryo.demo.async.app.TaskModule        : ▲ task[8a42f41f-d876-45fe-8fd4-40470b6db33b] done.
2021-05-18 22:03:42.615  INFO 8156 --- [        pool2-1] sugaryo.demo.async.app.TaskModule        : ▼ task[4523f975-b5fd-43d4-812f-223a141b86dd] doing.
2021-05-18 22:03:42.757  INFO 8156 --- [        pool2-2] sugaryo.demo.async.app.TaskModule        : ▲ task[cab1ef97-6788-42b5-b18e-8d7e296cfe66] done.
2021-05-18 22:03:42.976  INFO 8156 --- [        pool2-3] sugaryo.demo.async.app.TaskModule        : ▲ task[3e31e475-10fe-43b6-8dff-c256251e75d0] done.
2021-05-18 22:03:43.196  INFO 8156 --- [        pool2-4] sugaryo.demo.async.app.TaskModule        : ▲ task[43fc7078-2f90-4e3c-97b3-9aadd23117eb] done.
2021-05-18 22:03:43.667  INFO 8156 --- [        pool2-5] sugaryo.demo.async.app.TaskModule        : ▲ task[81874b54-e1ba-485b-a43c-a17dcbf79084] done.
2021-05-18 22:03:43.917  INFO 8156 --- [        pool2-6] sugaryo.demo.async.app.TaskModule        : ▲ task[a5369902-423d-4bc7-b517-ce6ddb684d0f] done.
2021-05-18 22:03:44.168  INFO 8156 --- [        pool2-7] sugaryo.demo.async.app.TaskModule        : ▲ task[80fa1be9-833a-44b6-a668-5e1e0fc66604] done.
2021-05-18 22:03:44.372  INFO 8156 --- [        pool2-8] sugaryo.demo.async.app.TaskModule        : ▲ task[709b016e-4de7-44a5-98ba-dbe4f724f2ca] done.
2021-05-18 22:03:44.624  INFO 8156 --- [        pool2-9] sugaryo.demo.async.app.TaskModule        : ▲ task[4b3caee3-0260-4ed6-b7be-70e486e5e106] done.
2021-05-18 22:03:45.140  INFO 8156 --- [       pool2-10] sugaryo.demo.async.app.TaskModule        : ▲ task[0efe6743-8045-4751-b879-a8bf37fe7326] done.
2021-05-18 22:03:45.439  INFO 8156 --- [       pool2-11] sugaryo.demo.async.app.TaskModule        : ▲ task[dfe9bdec-cf4f-4799-a06e-e231fc229099] done.
2021-05-18 22:03:45.642  INFO 8156 --- [       pool2-12] sugaryo.demo.async.app.TaskModule        : ▲ task[4604b965-9c25-44a1-8f70-58085817c7bf] done.
2021-05-18 22:03:45.815  INFO 8156 --- [       pool2-13] sugaryo.demo.async.app.TaskModule        : ▲ task[55a540a7-f28c-4228-a1f7-b18b69c6154e] done.
2021-05-18 22:03:45.989  INFO 8156 --- [       pool2-14] sugaryo.demo.async.app.TaskModule        : ▲ task[86b52a1c-adae-4588-b8c1-580e2e8ed5ca] done.
2021-05-18 22:03:46.176  INFO 8156 --- [       pool2-15] sugaryo.demo.async.app.TaskModule        : ▲ task[65007395-9e0d-4a5f-9352-e3d2e365ec8e] done.
2021-05-18 22:03:46.316  INFO 8156 --- [       pool2-16] sugaryo.demo.async.app.TaskModule        : ▲ task[5667e7f1-6358-492a-a16e-e758a70f859f] done.
2021-05-18 22:03:46.488  INFO 8156 --- [       pool2-17] sugaryo.demo.async.app.TaskModule        : ▲ task[f3317272-1d3c-4c42-8a7e-ad5f77e09794] done.
2021-05-18 22:03:46.661  INFO 8156 --- [       pool2-18] sugaryo.demo.async.app.TaskModule        : ▲ task[01193aa1-d0e6-4396-b445-6abb831d5db8] done.
2021-05-18 22:03:46.833  INFO 8156 --- [       pool2-19] sugaryo.demo.async.app.TaskModule        : ▲ task[a20d9f7e-8cc0-4f2a-bfbe-b0a56b425b4f] done.
2021-05-18 22:03:46.991  INFO 8156 --- [       pool2-20] sugaryo.demo.async.app.TaskModule        : ▲ task[000f9540-21ae-4788-8254-e59ff5b7f895] done.
2021-05-18 22:03:47.148  INFO 8156 --- [       pool2-21] sugaryo.demo.async.app.TaskModule        : ▲ task[da13fb6e-5b49-41c6-8c50-e7d64b5fb8a9] done.
2021-05-18 22:03:47.338  INFO 8156 --- [       pool2-22] sugaryo.demo.async.app.TaskModule        : ▲ task[b725e0e1-f4c8-4ff4-b60f-686203b176a5] done.
2021-05-18 22:03:47.495  INFO 8156 --- [       pool2-23] sugaryo.demo.async.app.TaskModule        : ▲ task[7ceefd02-5a00-4702-9cfb-5756a24ffd8e] done.
2021-05-18 22:03:47.684  INFO 8156 --- [       pool2-24] sugaryo.demo.async.app.TaskModule        : ▲ task[94716969-7668-4c66-b12f-472feffaee21] done.
2021-05-18 22:03:47.857  INFO 8156 --- [       pool2-25] sugaryo.demo.async.app.TaskModule        : ▲ task[86116c41-4e58-48ca-98ca-309930b8f764] done.
2021-05-18 22:03:48.015  INFO 8156 --- [       pool2-26] sugaryo.demo.async.app.TaskModule        : ▲ task[a0c42282-5c57-4466-94b3-349139c04a64] done.
2021-05-18 22:03:52.617  INFO 8156 --- [        pool2-1] sugaryo.demo.async.app.TaskModule        : ▲ task[4523f975-b5fd-43d4-812f-223a141b86dd] done.
```

## threadpool3 の実行ログ

|threadpool3|設定値|
|----|--|
|CorePoolSize|1|
|MaxPoolSize|500|
|QueueCapacity|1|

- curl 連打。

```log
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 2af48ed1-8854-4031-9341-9a983332cbfe
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 681a7edf-45f3-4280-8593-8f6c3ccdcb0e
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > eee96493-c5a3-4cda-b269-dd9cc13c44c0
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 1a6d58eb-6ed3-4e02-8f56-7d461387fd1a
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > a2f8cd70-d706-4ec4-993a-b5b2252e7760
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > ef85a60b-9bf8-4aff-be95-98c1132a3c88
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > b2f71d6e-2e87-4de1-8a45-93284699e554
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > eb55adeb-2a0c-4052-b087-0469bc8a7417
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 32bf7c3a-3171-40d3-9783-6eced582a3b8
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 7e114290-6886-4fee-8aa0-84824288b422
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 35ba694a-1175-45d6-aec5-926a54a99f36
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > e16c1355-9f4a-40af-b827-9034023224ca
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 73a4da89-7d39-411d-a0b9-aeb2eb3fb772
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 0f7b4475-46f7-40d6-838a-98c19a474e6f
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > ff926a2e-5eda-4354-9839-72294d971123
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 54253360-a816-400e-840b-dcea92f1c7c2
```

- SpringBootApplication側 の実行ログ

```log
2021-05-18 22:08:41.030  INFO 13436 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[2af48ed1-8854-4031-9341-9a983332cbfe] requested.
2021-05-18 22:08:41.058  INFO 13436 --- [        pool3-1] sugaryo.demo.async.app.TaskModule        : ▼ task[2af48ed1-8854-4031-9341-9a983332cbfe] doing.
2021-05-18 22:08:41.183  INFO 13436 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[681a7edf-45f3-4280-8593-8f6c3ccdcb0e] requested.
2021-05-18 22:08:41.184  INFO 13436 --- [        pool3-2] sugaryo.demo.async.app.TaskModule        : ▼ task[681a7edf-45f3-4280-8593-8f6c3ccdcb0e] doing.
2021-05-18 22:08:41.367  INFO 13436 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[eee96493-c5a3-4cda-b269-dd9cc13c44c0] requested.
2021-05-18 22:08:41.368  INFO 13436 --- [        pool3-3] sugaryo.demo.async.app.TaskModule        : ▼ task[eee96493-c5a3-4cda-b269-dd9cc13c44c0] doing.
2021-05-18 22:08:41.536  INFO 13436 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[1a6d58eb-6ed3-4e02-8f56-7d461387fd1a] requested.
2021-05-18 22:08:41.537  INFO 13436 --- [        pool3-4] sugaryo.demo.async.app.TaskModule        : ▼ task[1a6d58eb-6ed3-4e02-8f56-7d461387fd1a] doing.
2021-05-18 22:08:41.720  INFO 13436 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[a2f8cd70-d706-4ec4-993a-b5b2252e7760] requested.
2021-05-18 22:08:41.720  INFO 13436 --- [        pool3-5] sugaryo.demo.async.app.TaskModule        : ▼ task[a2f8cd70-d706-4ec4-993a-b5b2252e7760] doing.
2021-05-18 22:08:41.942  INFO 13436 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[ef85a60b-9bf8-4aff-be95-98c1132a3c88] requested.
2021-05-18 22:08:41.943  INFO 13436 --- [        pool3-6] sugaryo.demo.async.app.TaskModule        : ▼ task[ef85a60b-9bf8-4aff-be95-98c1132a3c88] doing.
2021-05-18 22:08:42.133  INFO 13436 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[b2f71d6e-2e87-4de1-8a45-93284699e554] requested.
2021-05-18 22:08:42.134  INFO 13436 --- [        pool3-7] sugaryo.demo.async.app.TaskModule        : ▼ task[b2f71d6e-2e87-4de1-8a45-93284699e554] doing.
2021-05-18 22:08:42.302  INFO 13436 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[eb55adeb-2a0c-4052-b087-0469bc8a7417] requested.
2021-05-18 22:08:42.303  INFO 13436 --- [        pool3-8] sugaryo.demo.async.app.TaskModule        : ▼ task[eb55adeb-2a0c-4052-b087-0469bc8a7417] doing.
2021-05-18 22:08:42.526  INFO 13436 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[32bf7c3a-3171-40d3-9783-6eced582a3b8] requested.
2021-05-18 22:08:42.527  INFO 13436 --- [        pool3-9] sugaryo.demo.async.app.TaskModule        : ▼ task[32bf7c3a-3171-40d3-9783-6eced582a3b8] doing.
2021-05-18 22:08:42.711  INFO 13436 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[7e114290-6886-4fee-8aa0-84824288b422] requested.
2021-05-18 22:08:42.712  INFO 13436 --- [       pool3-10] sugaryo.demo.async.app.TaskModule        : ▼ task[7e114290-6886-4fee-8aa0-84824288b422] doing.
2021-05-18 22:08:42.902  INFO 13436 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[35ba694a-1175-45d6-aec5-926a54a99f36] requested.
2021-05-18 22:08:42.903  INFO 13436 --- [       pool3-11] sugaryo.demo.async.app.TaskModule        : ▼ task[35ba694a-1175-45d6-aec5-926a54a99f36] doing.
2021-05-18 22:08:43.141  INFO 13436 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[e16c1355-9f4a-40af-b827-9034023224ca] requested.
2021-05-18 22:08:43.142  INFO 13436 --- [       pool3-12] sugaryo.demo.async.app.TaskModule        : ▼ task[e16c1355-9f4a-40af-b827-9034023224ca] doing.
2021-05-18 22:08:43.309  INFO 13436 --- [nio-8899-exec-6] sugaryo.demo.async.app.TaskController    : ■ task[73a4da89-7d39-411d-a0b9-aeb2eb3fb772] requested.
2021-05-18 22:08:43.310  INFO 13436 --- [       pool3-13] sugaryo.demo.async.app.TaskModule        : ▼ task[73a4da89-7d39-411d-a0b9-aeb2eb3fb772] doing.
2021-05-18 22:08:43.481  INFO 13436 --- [nio-8899-exec-7] sugaryo.demo.async.app.TaskController    : ■ task[0f7b4475-46f7-40d6-838a-98c19a474e6f] requested.
2021-05-18 22:08:43.482  INFO 13436 --- [       pool3-14] sugaryo.demo.async.app.TaskModule        : ▼ task[0f7b4475-46f7-40d6-838a-98c19a474e6f] doing.
2021-05-18 22:08:43.662  INFO 13436 --- [nio-8899-exec-8] sugaryo.demo.async.app.TaskController    : ■ task[ff926a2e-5eda-4354-9839-72294d971123] requested.
2021-05-18 22:08:43.663  INFO 13436 --- [       pool3-15] sugaryo.demo.async.app.TaskModule        : ▼ task[ff926a2e-5eda-4354-9839-72294d971123] doing.
2021-05-18 22:08:43.831  INFO 13436 --- [nio-8899-exec-9] sugaryo.demo.async.app.TaskController    : ■ task[54253360-a816-400e-840b-dcea92f1c7c2] requested.
2021-05-18 22:08:43.832  INFO 13436 --- [       pool3-16] sugaryo.demo.async.app.TaskModule        : ▼ task[54253360-a816-400e-840b-dcea92f1c7c2] doing.
2021-05-18 22:08:51.073  INFO 13436 --- [        pool3-1] sugaryo.demo.async.app.TaskModule        : ▲ task[2af48ed1-8854-4031-9341-9a983332cbfe] done.
2021-05-18 22:08:51.199  INFO 13436 --- [        pool3-2] sugaryo.demo.async.app.TaskModule        : ▲ task[681a7edf-45f3-4280-8593-8f6c3ccdcb0e] done.
2021-05-18 22:08:51.373  INFO 13436 --- [        pool3-3] sugaryo.demo.async.app.TaskModule        : ▲ task[eee96493-c5a3-4cda-b269-dd9cc13c44c0] done.
2021-05-18 22:08:51.545  INFO 13436 --- [        pool3-4] sugaryo.demo.async.app.TaskModule        : ▲ task[1a6d58eb-6ed3-4e02-8f56-7d461387fd1a] done.
2021-05-18 22:08:51.732  INFO 13436 --- [        pool3-5] sugaryo.demo.async.app.TaskModule        : ▲ task[a2f8cd70-d706-4ec4-993a-b5b2252e7760] done.
2021-05-18 22:08:51.954  INFO 13436 --- [        pool3-6] sugaryo.demo.async.app.TaskModule        : ▲ task[ef85a60b-9bf8-4aff-be95-98c1132a3c88] done.
2021-05-18 22:08:52.142  INFO 13436 --- [        pool3-7] sugaryo.demo.async.app.TaskModule        : ▲ task[b2f71d6e-2e87-4de1-8a45-93284699e554] done.
2021-05-18 22:08:52.316  INFO 13436 --- [        pool3-8] sugaryo.demo.async.app.TaskModule        : ▲ task[eb55adeb-2a0c-4052-b087-0469bc8a7417] done.
2021-05-18 22:08:52.536  INFO 13436 --- [        pool3-9] sugaryo.demo.async.app.TaskModule        : ▲ task[32bf7c3a-3171-40d3-9783-6eced582a3b8] done.
2021-05-18 22:08:52.721  INFO 13436 --- [       pool3-10] sugaryo.demo.async.app.TaskModule        : ▲ task[7e114290-6886-4fee-8aa0-84824288b422] done.
2021-05-18 22:08:52.913  INFO 13436 --- [       pool3-11] sugaryo.demo.async.app.TaskModule        : ▲ task[35ba694a-1175-45d6-aec5-926a54a99f36] done.
2021-05-18 22:08:53.149  INFO 13436 --- [       pool3-12] sugaryo.demo.async.app.TaskModule        : ▲ task[e16c1355-9f4a-40af-b827-9034023224ca] done.
2021-05-18 22:08:53.324  INFO 13436 --- [       pool3-13] sugaryo.demo.async.app.TaskModule        : ▲ task[73a4da89-7d39-411d-a0b9-aeb2eb3fb772] done.
2021-05-18 22:08:53.495  INFO 13436 --- [       pool3-14] sugaryo.demo.async.app.TaskModule        : ▲ task[0f7b4475-46f7-40d6-838a-98c19a474e6f] done.
2021-05-18 22:08:53.668  INFO 13436 --- [       pool3-15] sugaryo.demo.async.app.TaskModule        : ▲ task[ff926a2e-5eda-4354-9839-72294d971123] done.
2021-05-18 22:08:53.841  INFO 13436 --- [       pool3-16] sugaryo.demo.async.app.TaskModule        : ▲ task[54253360-a816-400e-840b-dcea92f1c7c2] done.
```

なるほど理解してきた。

## poor 設定の実行ログ

|poor|設定値|
|----|--|
|CorePoolSize|1|
|MaxPoolSize|4|
|QueueCapacity|0|

- curl 連打

```log
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 99e77b35-1e27-4162-a13c-a647c7b50e5b
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 21a2e357-3a88-4154-ac37-71aae58e2542
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 4accec22-ce28-4b20-aed1-bf3775d913b4
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > 09914549-befa-49d2-b3f2-e51c45fed80e
sugaryo@DESKTOP-555E2PN:~$ curl -XPOST 192.168.192.1:8899/api/task/do > too busy
```

- SpringBootApplication側 の実行ログ

```log
2021-05-18 22:11:21.898  INFO 11884 --- [nio-8899-exec-1] sugaryo.demo.async.app.TaskController    : ■ task[99e77b35-1e27-4162-a13c-a647c7b50e5b] requested.
2021-05-18 22:11:21.919  INFO 11884 --- [         poor-1] sugaryo.demo.async.app.TaskModule        : ▼ task[99e77b35-1e27-4162-a13c-a647c7b50e5b] doing.
2021-05-18 22:11:22.238  INFO 11884 --- [nio-8899-exec-2] sugaryo.demo.async.app.TaskController    : ■ task[21a2e357-3a88-4154-ac37-71aae58e2542] requested.
2021-05-18 22:11:22.238  INFO 11884 --- [         poor-2] sugaryo.demo.async.app.TaskModule        : ▼ task[21a2e357-3a88-4154-ac37-71aae58e2542] doing.
2021-05-18 22:11:22.663  INFO 11884 --- [nio-8899-exec-3] sugaryo.demo.async.app.TaskController    : ■ task[4accec22-ce28-4b20-aed1-bf3775d913b4] requested.
2021-05-18 22:11:22.664  INFO 11884 --- [         poor-3] sugaryo.demo.async.app.TaskModule        : ▼ task[4accec22-ce28-4b20-aed1-bf3775d913b4] doing.
2021-05-18 22:11:22.967  INFO 11884 --- [nio-8899-exec-4] sugaryo.demo.async.app.TaskController    : ■ task[09914549-befa-49d2-b3f2-e51c45fed80e] requested.
2021-05-18 22:11:22.968  INFO 11884 --- [         poor-4] sugaryo.demo.async.app.TaskModule        : ▼ task[09914549-befa-49d2-b3f2-e51c45fed80e] doing.
2021-05-18 22:11:23.356  INFO 11884 --- [nio-8899-exec-5] sugaryo.demo.async.app.TaskController    : ■ task[3889a1a3-bc4f-42b3-9b60-f25e8029f4c6] requested.
2021-05-18 22:11:23.361  WARN 11884 --- [nio-8899-exec-5] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@3d5b3672[Running, pool size = 4, active threads = 4, queued tasks = 0, completed tasks = 0]] did not accept task: org.springframework.aop.interceptor.AsyncExecutionInterceptor$$Lambda$715/0x0000000800493fc8@7c663c49]
2021-05-18 22:11:31.921  INFO 11884 --- [         poor-1] sugaryo.demo.async.app.TaskModule        : ▲ task[99e77b35-1e27-4162-a13c-a647c7b50e5b] done.
2021-05-18 22:11:32.240  INFO 11884 --- [         poor-2] sugaryo.demo.async.app.TaskModule        : ▲ task[21a2e357-3a88-4154-ac37-71aae58e2542] done.
2021-05-18 22:11:32.666  INFO 11884 --- [         poor-3] sugaryo.demo.async.app.TaskModule        : ▲ task[4accec22-ce28-4b20-aed1-bf3775d913b4] done.
2021-05-18 22:11:32.969  INFO 11884 --- [         poor-4] sugaryo.demo.async.app.TaskModule        : ▲ task[09914549-befa-49d2-b3f2-e51c45fed80e] done.
```

## 参考文献

- [Scheduled のスレッドプールサイズでハマった話 - Qiita](https://qiita.com/kshfthr/items/34126324cc71bfc4d469)
- [ThreadPoolTaskExecutor の挙動 - Qiita](https://qiita.com/hikoma/items/ffe4db14c4ac7f85616e)
- [誤解しがちなThreadPoolTaskExecutorの設定](https://blog.ik.am/entries/443)