SELECT * FROM `t_agent_order_1_0930` ORDER BY order_id desc;
SELECT * FROM `t_agent_order_1_0929` ORDER BY order_id desc;
SELECT * FROM `t_agent_order_1_0928` ORDER BY order_id desc;
SELECT * FROM `t_agent_order_1_0927` ORDER BY order_id desc;
SELECT * FROM `t_agent_order_1_0926` ORDER BY order_id desc;


### 绑定表
```editorconfig
分片键一致
join on 的字段必须是分片键
分片算法一致

><2个必须同时存在才能命中分片键，少一个则会多表扫描
```


